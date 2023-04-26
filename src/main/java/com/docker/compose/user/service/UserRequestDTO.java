package com.docker.compose.user.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotNull
    private String id;
    @NotBlank(message = "Username must not be empty!")
    private String username;
    @NotBlank(message = "FirstName must not be empty!")
    private String firstName;
    @NotBlank(message = "LastName must not be empty!")
    private String lastName;
    @NotBlank(message = "Password must not be empty!")
    private String address;
    @NotBlank(message = "Password must not be empty!")
    private String password;
    @Pattern(regexp = "^\\S+@\\S+\\.\\S+$", message = "Invalid email address.")
    private String email;

    private String city;
    private String number;
    private boolean admin;
}
