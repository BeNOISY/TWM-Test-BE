package com.docker.compose.products.service;

import java.util.List;
import java.util.Optional;

import com.docker.compose.products.persistance.entity.Specifics;
import com.docker.compose.products.persistance.entity.Product;
import com.docker.compose.products.persistance.repository.ProductRepository;
import com.docker.compose.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        product.setSpecs(product.getType());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional < Product > productDb = this.productRepository.findById(product.getId());

        if (productDb.isPresent()){
            Product productUpdate = productDb.get();
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setType(product.getType());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setCount(product.getCount());
            productUpdate.setDescription(product.getDescription());

            productUpdate.setSpecs(product.getType());

            productUpdate.setImg(product.getImg());

            productRepository.save(productUpdate);
            return productUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + product.getId());
        }
    }


    @Override
    public List < Product > getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public List < Product > getProductByType(String type) {
        return this.productRepository.findProductByType(type);
    }

    @Override
    public Product getProductById(long productId) {

        Optional < Product > productDb = this.productRepository.findById(productId);

        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }

    @Override
    public void deleteProduct(long productId) {
        Optional < Product > productDb = this.productRepository.findById(productId);

        if (productDb.isPresent()) {
            this.productRepository.delete(productDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }

    }

    @Override
    public void deleteCollection() {
        this.productRepository.deleteAll();
    }
}
