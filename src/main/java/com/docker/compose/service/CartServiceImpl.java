package com.docker.compose.service;


import com.docker.compose.exception.ResourceNotFoundException;
import com.docker.compose.model.Cart;
import com.docker.compose.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        Optional< Cart > cartDb = this.cartRepository.findById(cart.getId());

        if (cartDb.isPresent()) {

            Cart cartUpdate = cartDb.get();

            cartUpdate.setId(cart.getId());
            cartUpdate.setUsername(cart.getUsername());
            cartUpdate.setPrice(cart.getPrice());
            cartUpdate.setProductId(cart.getProductId());

            cartRepository.save(cartUpdate);
            return cartUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + cart.getId());
        }
    }


    @Override
    public List< Cart > getAllCart() {
        return this.cartRepository.findAll();
    }

    @Override
    public Cart getCartById(long cartId) {

        Optional < Cart > cartDb = this.cartRepository.findById(cartId);

        if (cartDb.isPresent()) {
            return cartDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + cartId);
        }
    }


    @Override
    public void deleteCart(long cartId) {
        Optional < Cart > cartDb = this.cartRepository.findById(cartId);

        if (cartDb.isPresent()) {
            this.cartRepository.delete(cartDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + cartId);
        }

    }

    @Override
    public void deleteCollection() {
        this.cartRepository.deleteAll();
    }
}
