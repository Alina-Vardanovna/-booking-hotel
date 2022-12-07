package com.example.bookinghotelcore.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private int phone;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;
    private boolean isEnabled;
    @ManyToOne
    private Home home;



}
