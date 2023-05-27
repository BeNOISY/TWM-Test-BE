package com.docker.compose.cart.service;

import com.docker.compose.EmailSenderService;
import com.docker.compose.cart.persistance.entity.Cart;
import com.docker.compose.cart.persistance.repository.CartRepository;
import com.docker.compose.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }
    private final CartRepository cartRepository;

    private EmailSenderService senderService;


    public Cart createCart(Cart cart) {

        return cartRepository.save(cart);
    }

    public List<Cart> getCartsByUserId(String userId){
        return cartRepository.findCartByUserId(userId);
    }

    public Cart updateCart(Cart cart) {
        Optional< Cart > cartDb = this.cartRepository.findById(cart.getId());

        if (cartDb.isPresent())
        {
            Cart cartUpdate = cartDb.get();

            cartUpdate.setId(cart.getId());
            cartUpdate.setUserId(cart.getUserId());
            cartUpdate.setFinalPrice(cart.getFinalPrice());
            cartUpdate.setTime(cart.getTime());
            cartUpdate.setProducts(cart.getProducts());

            cartRepository.save(cartUpdate);
            return cartUpdate;
        }
        else
        {
            throw new ResourceNotFoundException("Record not found with id : " + cart.getId());
        }
    }



    public List< Cart > getAllCart() {
        return this.cartRepository.findAll();
    }


    public Cart getCartById(String cartId)
    {

        Optional < Cart > cartDb = this.cartRepository.findById(cartId);

        if (cartDb.isPresent()) {
            return cartDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + cartId);
        }
    }



    public void deleteCart(String cartId) {
        Optional < Cart > cartDb = this.cartRepository.findById(cartId);

        if (cartDb.isPresent()) {
            this.cartRepository.delete(cartDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + cartId);
        }

    }


    public void deleteCollection() {
        this.cartRepository.deleteAll();
    }
}
