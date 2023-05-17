package com.docker.compose.user.persistance.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class User{

    @NotNull
    @Id
    private String id;
    @NotBlank(message = "Username must not be empty!")
    @Indexed(unique = true)
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
    @Indexed(unique = true)
    private String email;
    private String city;
    private String number;
    private boolean admin;
}
