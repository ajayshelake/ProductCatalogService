package com.example.productcatalogservice.repos;

import com.example.productcatalogservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Page<Product> findProductsByName(String query, Pageable pageable);

    List<Product> findProductsByOrderByPrice();

    @Query("SELECT p.name FROM products p WHERE p.id = ?1")
    String findProductTitleById(Long pid);

    @Query("SELECT p.category.name FROM products p WHERE p.id = :pid")
    String findCategoryNameFromProductId(Long pid);
}

