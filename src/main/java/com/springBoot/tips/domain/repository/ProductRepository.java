package com.springBoot.tips.domain.repository;

import com.springBoot.tips.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.disabled=false ")
    List<Product> findAllActiveProducts();
}