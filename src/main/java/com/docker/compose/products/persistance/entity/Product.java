package com.docker.compose.products.persistance.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Product {

    @Id
    private String id;
    private String name;
    private String type;
    private float price;
    private long count;
    private String description;
    private String img;
}

