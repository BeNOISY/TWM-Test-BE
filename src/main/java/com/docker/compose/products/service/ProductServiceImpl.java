package com.docker.compose.products.service;

import java.util.List;
import java.util.Optional;

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
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional < Product > productDb = this.productRepository.findById(product.getId());

        if (productDb.isPresent()) {
            Product productUpdate = productDb.get();
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setType(product.getType());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setCount(product.getCount());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setCapacity(product.getCapacity());
            productUpdate.setLifetime(product.getLifetime());
            productUpdate.setDisctype(product.getDisctype());
            productUpdate.setSeries(product.getSeries());
            productUpdate.setCores(product.getCores());
            productUpdate.setThreads(product.getThreads());
            productUpdate.setSocket(product.getSocket());
            productUpdate.setMemory(product.getMemory());
            productUpdate.setPorts(product.getPorts());
            productUpdate.setBacklight(product.getBacklight());
            productUpdate.setSpeed(product.getSpeed());
            productUpdate.setOs(product.getOs());
            productUpdate.setPlug(product.getPlug());
            productUpdate.setWatts(product.getWatts());
            productUpdate.setModular(product.getModular());
            productUpdate.setPins(product.getPins());
            productUpdate.setCoolingtype(product.getCoolingtype());
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
        System.out.println(type);
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
