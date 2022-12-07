package com.example.bookinghotelrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.example.bookinghotelcore.*", "com.example.bookinghotelrest.*"})
@EnableJpaRepositories(basePackages = {"com.example.bookinghotelcore.repository"})
@EntityScan({"com.example.bookinghotelcore.entity"})
@SpringBootApplication
public class BookingHotelRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingHotelRestApplication.class, args);
    }

}
