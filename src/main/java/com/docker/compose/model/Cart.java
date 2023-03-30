package com.docker.compose.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Document(collection = "CartDB")
public class Cart {

    @Id
    private long _id;

    @NotBlank
    @Size(max = 100)
    private String userId;//user ID instead

    private String productId;

    private float price;
    private long time;

    public long getId() {
        return _id;
    }
    public void setId(long id) {
        this._id = id;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {this.userId = userId;}

    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setPrice(float price) {this.price = price;}
    public float getPrice() {return price;}
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
}
