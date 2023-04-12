package com.docker.compose.user.persistance.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class User{
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String realName;
    private boolean admin;
    @Indexed(unique = true)
    private String email;
    private String address;
    private String city;

    public User(String username,
                String realName,
                boolean admin,
                String email,
                String address,
                String city) {
        this.username = username;
        this.realName = realName;
        this.admin = admin;
        this.email = email;
        this.address = address;
        this.city = city;
    }
}
