package com.docker.compose.cart.service;

import com.docker.compose.cart.persistance.entity.Cart;

import java.util.List;

public interface CartService {
    Cart createCart(Cart cart);

    Cart updateCart(Cart cart);

    List< Cart > getAllCart();

    Cart getCartById(String cartId);

    void deleteCart(String cartId);

    void deleteCollection();
}
