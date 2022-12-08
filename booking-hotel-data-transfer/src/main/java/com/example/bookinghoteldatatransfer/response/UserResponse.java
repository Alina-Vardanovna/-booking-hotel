package com.example.bookinghoteldatatransfer.response;

import com.example.bookinghoteldatatransfer.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private UserRole role;
    private Date createAt;

}
