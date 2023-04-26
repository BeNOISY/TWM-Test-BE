package com.docker.compose.cart.service;

import com.docker.compose.EmailSenderService;
import com.docker.compose.cart.persistance.entity.Cart;
import com.docker.compose.cart.persistance.repository.CartRepository;
import com.docker.compose.exception.ResourceNotFoundException;
import com.docker.compose.products.persistance.entity.Product;
import com.docker.compose.user.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartService {

    private CartRepository cartRepository;

    private EmailSenderService senderService;


    public Cart createCart(Cart cart) {
        User user = cart.getUser();
        List<Product> products = cart.getProducts();
        ArrayList<String> finalProducts = new ArrayList<>();
        products.forEach(product -> {
            finalProducts.add(product.getName() + "\n");
            finalProducts.add((product.getPrice()) + "€\n");
        });
        senderService.sendSimpleEmail(user.getEmail(),
                "TWM Electronics receipt no.:" + cart.getTime(),
//                "Hi " + user.getUsername() +"." +
//                        "\n" +
//                        "\n" +
//                        "Thank you for your purchase!" +
//                        "\nHere is your purchase summary:" +
//                        "\n"
//                        + finalProducts
//                        .toString()
//                        .replace("[","")
//                        .replace("]", "")
//                        .replace(",","") +
//                        "\n" +
//                        "Total price: " + cart.getFinalPrice()+ "€" +
//                        "\nTime of purchase: " + cart.getTime() + "" +
//                        "\n We send your purchase to: " + user.getAddress() + ", in: " + user.getCity() + "." +
//                        "\nTWM Electronics thank you for your purchase and hope that you will come again!"

                "email content"
                //TODO Email/ThymeLeaf System
        );
        return cartRepository.save(cart);
    }


    public Cart updateCart(Cart cart) {
        Optional< Cart > cartDb = this.cartRepository.findById(cart.getId());

        if (cartDb.isPresent()) {

            Cart cartUpdate = cartDb.get();

            cartUpdate.setId(cart.getId());
            cartUpdate.setUser(cart.getUser());
            cartUpdate.setFinalPrice(cart.getFinalPrice());
            cartUpdate.setTime(cart.getTime());
            cartUpdate.setProducts(cart.getProducts());

            cartRepository.save(cartUpdate);
            return cartUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + cart.getId());
        }
    }



    public List< Cart > getAllCart() {
        return this.cartRepository.findAll();
    }


    public Cart getCartById(String cartId) {

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
