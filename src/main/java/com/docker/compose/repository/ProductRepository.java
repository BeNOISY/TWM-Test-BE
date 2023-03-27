package com.docker.compose.repository;

import com.docker.compose.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository <Product, Long > {
    @Query("{ 'type' : ?0 }")
    List<Product> findProductByType(String type);

}
