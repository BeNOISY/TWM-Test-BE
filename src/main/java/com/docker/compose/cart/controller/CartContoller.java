package com.docker.compose.cart.controller;

import com.docker.compose.cart.email.service.EmailService;
import com.docker.compose.cart.service.CartService;
import com.docker.compose.cart.persistance.entity.Cart;
import com.docker.compose.user.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class CartContoller {

    @Autowired
    private CartService cartService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/cart")
    public ResponseEntity<List<Cart>> gerAllCart() {
        return ResponseEntity.ok().body(cartService.getAllCart());
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity < Cart > getCartId(@PathVariable String id) {
        return ResponseEntity.ok().body(cartService.getCartById(id));
    }

    @PostMapping("/cart")
    public ResponseEntity < Cart > createCart(@RequestBody Cart cart) {
        User recipient = cart.getUser();
        emailService.sendEmail(recipient.getEmail(), "Your order no." + cart.getId(),
                "Your order was successful. You ordered:" + cart.getProducts());
        return ResponseEntity.ok().body(this.cartService.createCart(cart));
    }

    @PutMapping("/cart/{id}")
    public ResponseEntity < Cart > updateCart(@PathVariable String id, @RequestBody Cart cart) {
        cart.setId(id);
        return ResponseEntity.ok().body(this.cartService.updateCart(cart));
    }

    @DeleteMapping("/cart/{id}")
    public HttpStatus deleteCart(@PathVariable String id) {
        this.cartService.deleteCart(id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/cart")
    public HttpStatus deleteCollection() {
        this.cartService.deleteCollection();
        return HttpStatus.OK;
    }

}
