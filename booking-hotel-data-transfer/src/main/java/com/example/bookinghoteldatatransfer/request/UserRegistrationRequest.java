package com.example.bookinghoteldatatransfer.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequest {

    private String name;
    private String surname;
    private String phone;
    private String email;
    private String password;

}
