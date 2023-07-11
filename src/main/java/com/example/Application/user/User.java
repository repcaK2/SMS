package com.example.Application.user;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;
    private String password;
    private double balance;
}
