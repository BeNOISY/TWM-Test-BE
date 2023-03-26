package com.docker.compose.service;

import com.docker.compose.model.Cart;

import java.util.List;

public interface CartService {
    Cart createCart(Cart product);

    Cart updateCart(Cart product);

    List< Cart > getAllCart();

    Cart getCartById(long productId);

    void deleteCart(long id);

    void deleteCollection();
}
