package com.docker.compose.repository;

import com.docker.compose.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository <Product, Long > {

}
