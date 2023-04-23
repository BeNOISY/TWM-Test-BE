package com.docker.compose.cart.persistance.entity;

import com.docker.compose.products.persistance.entity.Product;
import com.docker.compose.user.persistance.entity.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document
public class Cart {

    @Id
    private String id;
    private User user;
    private List<Product> products;
    private float finalPrice;
    private String time;

}
