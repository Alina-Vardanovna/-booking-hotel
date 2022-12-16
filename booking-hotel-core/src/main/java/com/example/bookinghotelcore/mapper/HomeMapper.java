package com.example.bookinghotelcore.mapper;

import com.example.bookinghotelcore.entity.Home;
import com.example.bookinghotelcore.mapper.base.BaseMapper;
import com.example.bookinghoteldatatransfer.request.HomeRequest;
import com.example.bookinghoteldatatransfer.response.HomeResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeMapper implements BaseMapper<Home, HomeRequest, HomeResponse> {

    private final ModelMapper modelMapper;

    @Override
    public Home toEntity(HomeRequest homeRequest) {
        return modelMapper.map(homeRequest, Home.class);
    }

    @Override
    public HomeResponse toResponse(Home home) {
        return modelMapper.map(home, HomeResponse.class);
    }

}
