package com.example.bookinghotelcore.service.impl;

import com.example.bookinghotelcore.entity.User;
import com.example.bookinghotelcore.exception.UserNotFoundException;
import com.example.bookinghotelcore.mapper.UserMapper;
import com.example.bookinghotelcore.repository.UserRepository;
import com.example.bookinghotelcore.service.UserService;
import com.example.bookinghoteldatatransfer.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User findById(final Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(
                "User with " + id + " id" + " is NOT FOUND"));
    }

    public User findByEmail(final String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(
                "User with " + email + " id" + " is NOT FOUND"));
    }

    public List<UserResponse> findAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toCollection(LinkedList::new));
    }

}
