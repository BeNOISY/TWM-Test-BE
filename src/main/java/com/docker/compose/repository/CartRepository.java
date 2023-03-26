package com.docker.compose.repository;

import com.docker.compose.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends MongoRepository<Cart, Long > {
}
