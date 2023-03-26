package com.docker.compose.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Document(collection = "CartDB")
public class Cart {

    @Id
    private long id;

    @NotBlank
    @Size(max = 100)
    private String username;//user ID instead

    private String productId;

    private int price;
    private long time;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {this.username = username;}

    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setPrice(int price) {this.price = price;}
    public int getPrice() {return price;}
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
}
