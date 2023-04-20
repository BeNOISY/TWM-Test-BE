package com.docker.compose.user.persistance.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class User{

    @Id
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private boolean admin;
    private String email;
    private String address;
    private String password;
    private String city;
    private String number;
}
