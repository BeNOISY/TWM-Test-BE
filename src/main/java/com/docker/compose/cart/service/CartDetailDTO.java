package com.docker.compose.cart.service;

import com.docker.compose.products.persistance.entity.Product;
import com.docker.compose.user.persistance.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class CartDetailDTO {

    private String id;
    private User user;
    private List<Product> products;
    private float finalPrice;
    private String time;
}
