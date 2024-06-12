package com.springBoot.tips.rest;

import com.springBoot.tips.models.Product;
import com.springBoot.tips.domain.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnProducts() throws Exception {
        Product p1 = new Product(1L , "name1" , "desc1" , BigDecimal.TEN , true);
        Product p2 = new Product(2L , "name2" , "desc2" , BigDecimal.TEN , false);
        BDDMockito.given(productService.getAllProducts()).willReturn(List.of(p1 , p2));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("name1"))
                .andExpect(jsonPath("$[0].description").value("desc1"))
                .andExpect(jsonPath("$[0].price").value(10))
                .andExpect(jsonPath("$[0].disabled").value(true))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("name2"))
                .andExpect(jsonPath("$[1].description").value("desc2"))
                .andExpect(jsonPath("$[1].price").value(10))
                .andExpect(jsonPath("$[1].disabled").value(false));
    }
}