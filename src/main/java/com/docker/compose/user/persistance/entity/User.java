package com.docker.compose.user.persistance.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


@Data
@Document
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    private String id;

    @Indexed(unique = true)
    @Size(max = 60)
    @NotNull
    private String email;
    @Indexed(unique = true)
    @NotNull
    @Size(min = 3, max = 30)
    private String username;
    @NotNull
    @Size(min = 6, max = 60)
    private String password;

    private String firstName;
    private String lastName;
    private boolean admin;
    private String address;
    private String city;
    private String number;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
