package com.example.bookinghoteldatatransfer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HomeResponse {

    private long id;
    private String title;
    private BigDecimal price;
    private String description;
    private UserResponse user;

}
