package com.springBoot.tips.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductServiceTest {
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    void setUp() {
         productRepository = Mockito.mock(ProductRepository.class);
         productService = new ProductService(productRepository);
    }

    @Test
    void ShouldReturnOnlyActiveProducts() {
        //Arrange
        Product p1 = new Product(1L , "name1" , "desc1" , BigDecimal.TEN , false);
        Product p2 = new Product(2L , "name2" , "desc2" , BigDecimal.TEN , true);
        Product p3 = new Product(3L , "name3" , "desc3" , BigDecimal.TEN , true);
        Product p4 = new Product(4L , "name4" , "desc4" , BigDecimal.TEN , false);

        BDDMockito.given(productRepository.findAll()).willReturn(List.of(p1 , p2 , p3 , p4));

        //Act
        List<Product> products = productService.getAllProducts();

        //Assert
        assertThat(products).hasSize(2);
    }
}