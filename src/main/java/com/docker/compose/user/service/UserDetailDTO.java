package com.docker.compose.user.service;

import lombok.Data;

@Data
public class UserDetailDTO {

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
