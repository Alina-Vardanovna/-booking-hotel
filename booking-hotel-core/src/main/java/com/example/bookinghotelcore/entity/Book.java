package com.example.bookinghotelcore.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book_orders")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Home home;
    @ManyToOne
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date bookDateTime;

}
