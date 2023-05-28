package com.docker.compose.purchase.service;

import com.docker.compose.products.persistance.entity.Product;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class PurchaseRequestDto {

    private String id;
    private String email;
    private List<Product>   products;
    private float finalPrice;
    private String time;

}
