package com.docker.compose.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "UserDB")
public class User {


    @Id
    private long _id;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
    private String username;
    private String realname;
    private boolean admin;
    private String email;
    private String address;
    private String city;

    public long getId() {
        return _id;
    }
    public void setId(long _id) {
        this._id = _id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String name) {
        this.username = name;
    }
    public String getRealname() {
        return realname;
    }
    public void setRealname(String realname) {
        this.realname = realname;
    }
    public boolean getAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}
