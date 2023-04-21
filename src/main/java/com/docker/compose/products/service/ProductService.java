package com.docker.compose.products.service;

import com.docker.compose.products.persistance.entity.Product;

import java.util.List;


public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(Product product);

    List < Product > getAllProduct();

    List<Product> getProductByType(String type);

    public List<Product> getProductsByAdditional(String additional);

    Product getProductById(String productId);

    void deleteProduct(String id);

    void deleteCollection();
}
