package com.docker.compose.products.service;
import com.docker.compose.products.persistance.entities.Product;

import java.util.List;



public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(Product product);

    List < Product > getAllProduct();

    List < Product > getProductByType(String type);

    Product getProductById(long productId);

    void deleteProduct(long id);

    void deleteCollection();
}
