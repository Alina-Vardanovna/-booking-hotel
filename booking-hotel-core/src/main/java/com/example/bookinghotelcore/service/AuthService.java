package com.example.bookinghotelcore.service;

import com.example.bookinghoteldatatransfer.request.UserAuthRequest;
import com.example.bookinghoteldatatransfer.request.UserRegistrationRequest;
import com.example.bookinghoteldatatransfer.response.UserAuthResponse;
import com.example.bookinghoteldatatransfer.response.UserRegistrationResponse;

public interface AuthService {

    UserAuthResponse auth(UserAuthRequest userAuthRequest);

    UserRegistrationResponse registration(UserRegistrationRequest userRegistrationRequest);

}
