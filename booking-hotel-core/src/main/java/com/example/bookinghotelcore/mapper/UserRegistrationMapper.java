package com.example.bookinghotelcore.mapper;

import com.example.bookinghotelcore.entity.User;
import com.example.bookinghotelcore.mapper.base.BaseMapper;
import com.example.bookinghoteldatatransfer.request.UserAuthRequest;
import com.example.bookinghoteldatatransfer.request.UserRegistrationRequest;
import com.example.bookinghoteldatatransfer.response.UserAuthResponse;
import com.example.bookinghoteldatatransfer.response.UserRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationMapper implements BaseMapper<User, UserRegistrationRequest, UserRegistrationResponse> {

    private final ModelMapper modelMapper;

    @Override
    public User toEntity(UserRegistrationRequest userRegistrationRequest) {
        return modelMapper.map(userRegistrationRequest, User.class);
    }

    @Override
    public UserRegistrationResponse toResponse(User user) {
        return modelMapper.map(user, UserRegistrationResponse.class);
    }
}
