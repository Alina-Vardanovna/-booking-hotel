package com.example.bookinghotelcore.mapper;

import com.example.bookinghotelcore.entity.User;
import com.example.bookinghotelcore.mapper.base.BaseMapper;
import com.example.bookinghoteldatatransfer.request.UserRequest;
import com.example.bookinghoteldatatransfer.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper implements BaseMapper<User, UserRequest, UserResponse> {

    private final ModelMapper modelMapper;

    @Override
    public User toEntity(UserRequest userRequest) {
        return modelMapper.map(userRequest, User.class);
    }

    @Override
    public UserResponse toResponse(User user) {
        return modelMapper.map(user, UserResponse.class);
    }
}
