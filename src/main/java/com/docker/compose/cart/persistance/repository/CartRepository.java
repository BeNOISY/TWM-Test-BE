package com.docker.compose.cart.persistance.repository;

import com.docker.compose.cart.persistance.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends MongoRepository<Cart, Long > {
}
