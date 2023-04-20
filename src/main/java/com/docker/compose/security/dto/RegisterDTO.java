package com.docker.compose.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
public class RegisterDTO {
    @Id
    private String id;

    @NotBlank
    @Size(min = 3, max = 30)
    private String username;
    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    @NotBlank
    @Size(min = 6, max = 60)
    private String password;

    private String firstName;
    private String lastName;
    private boolean admin;
    private String address;
    private String city;
    private String number;
}
