package com.example.bookinghotelrest.endpoint;

import com.example.bookinghotelcore.service.AuthService;
import com.example.bookinghoteldatatransfer.request.UserAuthRequest;
import com.example.bookinghoteldatatransfer.request.UserRegistrationRequest;
import com.example.bookinghoteldatatransfer.response.UserAuthResponse;
import com.example.bookinghoteldatatransfer.response.UserRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthEndpoint {

    private final AuthService authService;

    @GetMapping
    public ResponseEntity<?> userAuth(@RequestBody UserAuthRequest userAuthRequest) {
        UserAuthResponse auth = authService.auth(userAuthRequest);
        return ResponseEntity.ok(auth);
    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        UserRegistrationResponse register = authService.registration(userRegistrationRequest);
        return ResponseEntity.ok(register);
    }
}
