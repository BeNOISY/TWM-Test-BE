package com.docker.compose.security.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TokenDTO {
    private String UserID;
    private String accessToken;
    private String refreshToken;

}
