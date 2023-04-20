package com.docker.compose.products.persistance.repository;

import com.docker.compose.products.persistance.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Map;

public interface ProductRepository extends MongoRepository <Product, String> {

    List<Product> findProductsByType(String type);

    List<Product> findProductsByParameter(String type, Map<String, String> parameter);
}
