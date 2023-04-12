package com.docker.compose.products.persistance.repository;

import com.docker.compose.products.persistance.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository <Product, Long> {

}
