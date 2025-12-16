package com.example.productcatalogservice.service;

import com.example.productcatalogservice.models.Product;

import java.util.List;

public interface IProductService {
    Product createProduct(Product product);
    Product replaceProduct(Long id,Product input);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void deleteProduct(Long id);
}
