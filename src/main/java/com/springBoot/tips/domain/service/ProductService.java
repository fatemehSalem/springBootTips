package com.springBoot.tips.domain.service;

import com.springBoot.tips.domain.repository.ProductRepository;
import com.springBoot.tips.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    private  ProductRepository productRepository;
    @Autowired
    public void setProductRepository (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .filter(p -> !p.isDisabled())
                .toList();
    }
}