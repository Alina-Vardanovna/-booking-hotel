package com.example.bookinghotelcore.mapper;

import com.example.bookinghotelcore.entity.User;
import com.example.bookinghoteldatatransfer.request.UserRequest;
import com.example.bookinghoteldatatransfer.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper implements BaseMapper<User, UserRequest, UserResponse>{

    @Override
    public User toEntity(UserRequest userRequest) {
        return null;
    }

    @Override
    public UserResponse toResponse(User user) {
        return null;
    }

}
