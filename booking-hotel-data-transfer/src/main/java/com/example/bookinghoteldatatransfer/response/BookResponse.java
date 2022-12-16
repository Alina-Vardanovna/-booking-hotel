package com.example.bookinghoteldatatransfer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private int id;
    private HomeResponse home;
    private UserResponse user;
    private Date bookDateTime;

}
