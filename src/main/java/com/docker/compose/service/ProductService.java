package com.docker.compose.service;
import com.docker.compose.model.Product;

import java.util.List;
import org.springframework.data.mongodb.core.query.Query;


public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(Product product);

    List < Product > getAllProduct();

    Product getProductById(long productId);

    List <Product> getProductByCategory(Query query);

    void deleteProduct(long id);

    void deleteCollection();
}
