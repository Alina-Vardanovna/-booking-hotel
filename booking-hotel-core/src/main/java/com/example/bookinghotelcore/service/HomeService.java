package com.example.bookinghotelcore.service;

import com.example.bookinghotelcore.entity.Home;
import com.example.bookinghoteldatatransfer.request.HomeRequest;
import com.example.bookinghoteldatatransfer.response.HomeResponse;

import java.awt.print.Pageable;
import java.util.List;

public interface HomeService {

    Home save(HomeRequest homeRequest, long userId);

    void deleteById(long homeId, long userId);

    Home findById(long id);

    Home findByIdAndUserId(long homeId, long userId);

    List<HomeResponse> findAll(Pageable pageable);

    List<HomeResponse> findAllByUserId(long userId, Pageable pageable);

}
