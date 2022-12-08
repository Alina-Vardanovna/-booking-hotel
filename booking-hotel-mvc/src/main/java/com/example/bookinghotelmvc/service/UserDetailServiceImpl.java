package com.example.bookinghotelmvc.service;

import com.example.bookinghotelcore.entity.User;
import com.example.bookinghotelcore.repository.UserRepository;
import com.example.bookinghotelmvc.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byEmail = userRepository.findByEmail(username);
        if (byEmail.isPresent()) {
            return new CurrentUser(byEmail.get());
        } else {
            throw new UsernameNotFoundException("Username does not exists");
        }
    }
}

