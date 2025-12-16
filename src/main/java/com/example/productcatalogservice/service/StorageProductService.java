package com.example.productcatalogservice.service;

import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageProductService implements IProductService{
    @Autowired
    ProductRepo productRepo;
    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }
}
