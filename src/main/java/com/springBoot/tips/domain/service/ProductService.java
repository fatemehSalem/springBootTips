package com.springBoot.tips.domain.service;

import com.springBoot.tips.domain.repository.ProductRepository;
import com.springBoot.tips.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .filter(p -> !p.isDisabled())
                .toList();
    }
}