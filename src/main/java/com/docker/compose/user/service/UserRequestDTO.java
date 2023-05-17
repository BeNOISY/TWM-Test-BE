package com.docker.compose.user.service;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.intellij.lang.annotations.Identifier;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class UserRequestDTO {

    @NotNull
    private String id;
    @NotBlank(message = "Username must not be empty!")
    @Indexed(unique = true)
    private String username;
    @NotBlank(message = "FirstName must not be empty!")
    private String firstName;
    @NotBlank(message = "LastName must not be empty!")
    private String lastName;
    @NotBlank(message = "Address must not be empty!")
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
