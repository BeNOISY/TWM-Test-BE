package com.docker.compose.cart.controller;

import com.docker.compose.cart.email.EmailSenderService;
import com.docker.compose.cart.persistance.entity.Cart;
import com.docker.compose.cart.service.CartService;
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
    private EmailSenderService senderService;

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

        User user = cart.getUser();
        senderService.sendSimpleEmail(user.getEmail(),
                "Your order no." + cart.getId(),
                "Skuska123"
        );

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
