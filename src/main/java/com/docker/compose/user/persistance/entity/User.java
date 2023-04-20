package com.docker.compose.user.persistance.entity;

<<<<<<< HEAD
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
=======
>>>>>>> parent of 6262920 (Added Tokens)
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
<<<<<<< HEAD
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
=======
public class User{

    @Id
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private boolean admin;
    private String email;
>>>>>>> parent of 6262920 (Added Tokens)
    private String address;
    private String city;
    private String number;

<<<<<<< HEAD

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
=======
>>>>>>> parent of 6262920 (Added Tokens)
}
