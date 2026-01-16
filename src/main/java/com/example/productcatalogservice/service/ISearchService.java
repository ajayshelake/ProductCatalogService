package com.example.productcatalogservice.service;

import com.example.productcatalogservice.dtos.SortParam;
import com.example.productcatalogservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISearchService {

    Page<Product> searchProducts(String searchQuery, int pageSize, int pageNumber, List<SortParam> sortParams);
}
