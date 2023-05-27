package com.docker.compose.cart.persistance.entity;

import com.docker.compose.products.persistance.entity.Product;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document
public class Cart {

    @Id
    private String id;
    @Indexed(unique = false)
    private String userId;

    private List<Product> products;
    private float finalPrice;
    private String time;

}
