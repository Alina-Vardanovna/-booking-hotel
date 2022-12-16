package com.example.bookinghotelcore.service;

import com.example.bookinghotelcore.entity.User;

public interface UserService {

    User findById(Long id);

    User findByEmail(final String email);

}
