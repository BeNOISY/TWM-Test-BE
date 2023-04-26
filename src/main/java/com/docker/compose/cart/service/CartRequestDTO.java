package com.docker.compose.cart.service;

import com.docker.compose.products.persistance.entity.Product;
import com.docker.compose.user.persistance.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CartRequestDTO {

    @NotNull
    private String id;
    @NotBlank(message = "User in cart must be included!")
    private User user;
    @NotBlank(message = "You must include at the least one product!")
    private List<Product> products;
    @NotBlank(message = "Final price is needed!")
    private float finalPrice;
    private String time;
}
