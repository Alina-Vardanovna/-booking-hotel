package com.example.bookinghoteldatatransfer.request;

import com.example.bookinghoteldatatransfer.response.HomeResponse;
import com.example.bookinghoteldatatransfer.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    private Date bookDateTime;

}
