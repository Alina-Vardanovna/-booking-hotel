package com.example.bookinghotelcore.service.impl;

import com.example.bookinghotelcore.entity.User;
import com.example.bookinghotelcore.exception.AuthenticatedException;
import com.example.bookinghotelcore.exception.DuplicateResourceException;
import com.example.bookinghotelcore.mapper.UserRegistrationMapper;
import com.example.bookinghotelcore.repository.UserRepository;
import com.example.bookinghotelcore.service.AuthService;
import com.example.bookinghotelcore.util.JwtTokenUtil;
import com.example.bookinghoteldatatransfer.model.UserRole;
import com.example.bookinghoteldatatransfer.request.UserAuthRequest;
import com.example.bookinghoteldatatransfer.request.UserRegistrationRequest;
import com.example.bookinghoteldatatransfer.response.UserAuthResponse;
import com.example.bookinghoteldatatransfer.response.UserRegistrationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRegistrationMapper userRegistrationMapper;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public UserAuthResponse auth(UserAuthRequest userAuthRequest) {
        log.info("Request from user {} to get authenticated", userAuthRequest.getEmail());
        Optional<User> optionalUser = userRepository.findByEmail(userAuthRequest.getEmail());

        if (optionalUser.isEmpty()
                || !passwordEncoder.matches(userAuthRequest.getPassword(), optionalUser.get().getPassword())) {
            log.error("{}: Provided wrong credentials for authentication", userAuthRequest.getEmail());
            throw new AuthenticatedException(userAuthRequest.getEmail() + ": Provided wrong credentials for authentication");
        }
        log.info("Succeed get user by email: {}", userAuthRequest.getEmail());
        return UserAuthResponse.builder()
                .token(jwtTokenUtil.generateToken(userAuthRequest.getEmail()))
                .build();
    }

    @Override
    public UserRegistrationResponse registration(UserRegistrationRequest userRequest) {
        log.info("Request from user {} to registration", userRequest.getEmail());
        Optional<User> byEmail = userRepository.findByEmail(userRequest.getEmail());
        if (byEmail.isPresent()) {
            log.error("User with email: {} already exists", userRequest.getEmail());
            throw new DuplicateResourceException("User with email: " + userRequest.getEmail() + " already exists");
        }
        User user = userRegistrationMapper.toEntity(userRequest);
        user.setRole(UserRole.USER);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRepository.save(user);
        log.info("Succeed registered user by email: {}", userRequest.getEmail());
        return userRegistrationMapper.toResponse(user);
    }

}
