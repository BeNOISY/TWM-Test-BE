package com.docker.compose.controller;

import com.docker.compose.model.Cart;
import com.docker.compose.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class CartContoller {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public ResponseEntity<List<Cart>> gerAllCart() {
        return ResponseEntity.ok().body(cartService.getAllCart());
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity < Cart > getCartId(@PathVariable long id) {
        return ResponseEntity.ok().body(cartService.getCartById(id));
    }

    @PostMapping("/cart")
    public ResponseEntity < Cart > createCart(@RequestBody Cart cart) {
        return ResponseEntity.ok().body(this.cartService.createCart(cart));
    }

    @PutMapping("/cart/{id}")
    public ResponseEntity < Cart > updateCart(@PathVariable long id, @RequestBody Cart cart) {
        cart.setId(id);
        return ResponseEntity.ok().body(this.cartService.updateCart(cart));
    }

    @DeleteMapping("/cart/{id}")
    public HttpStatus deleteCart(@PathVariable long id) {
        this.cartService.deleteCart(id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/cart")
    public HttpStatus deleteCollection() {
        this.cartService.deleteCollection();
        return HttpStatus.OK;
    }
}
