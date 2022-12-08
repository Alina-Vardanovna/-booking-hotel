package com.example.bookinghotelcore.entity;


import lombok.*;

import javax.annotation.Resource;
import javax.persistence.*;

@Getter
@Setter
@Data
@ToString
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
    private UserRole role;
//    private boolean isEnabled;

}
