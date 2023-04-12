package com.docker.compose.products.persistance.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "ProductDB")
public class Product {

    @Id
    private long id;
    private String name;
    private String type;
    private float price;
    private long count;
    private String description;

    private String img;

    //Basic Getters ------------------------------
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public float getPrice() {
        return price;
    }
    public long getCount() {
        return count;
    }
    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }


    //Setters --------------------------------------------

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImg(String img) {
        this.img = img;
    }


}

