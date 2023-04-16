package com.docker.compose.cart.service;

import com.docker.compose.cart.persistance.entity.Cart;

import java.util.List;

public interface CartService {
    Cart createCart(Cart product);

    Cart updateCart(Cart product);

    List< Cart > getAllCart();

    Cart getCartById(String productId);

    void deleteCart(String id);

    void deleteCollection();
}
