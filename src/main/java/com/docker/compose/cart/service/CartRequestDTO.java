package com.docker.compose.cart.service;

import com.docker.compose.products.persistance.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class CartRequestDTO {

    private String id;

    private String userId;

    private List<Product> products;
    private float finalPrice;
    private String time;
}
