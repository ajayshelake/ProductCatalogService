package com.example.productcatalogservice.service;

import com.example.productcatalogservice.dtos.SortParam;
import com.example.productcatalogservice.dtos.SortType;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaSearchService implements ISearchService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Page<Product> searchProducts(String searchQuery, int pageSize, int pageNumber, List<SortParam> sortParams) {

        Sort sort = Sort.unsorted();

        if (sortParams != null && !sortParams.isEmpty()) {
            for (SortParam param : sortParams) {
                Sort currentSort = param.getSortType() == SortType.ASC
                        ? Sort.by(param.getSortCriteria())
                        : Sort.by(param.getSortCriteria()).descending();

                sort = sort.and(currentSort);
            }
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return productRepo.findProductsByName(searchQuery,
                pageable);
    }
}
