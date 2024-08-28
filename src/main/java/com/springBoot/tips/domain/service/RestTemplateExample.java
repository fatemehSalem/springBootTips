package com.springBoot.tips.domain.service;

import com.springBoot.tips.models.Customer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateExample {
    private static final String BASE_URL = "http://localhost:8080/customers";

    private RestTemplate restTemplate = new RestTemplate();

    public Customer createCustomer(Customer customer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create HttpEntity with the Customer object to be serialized to JSON
        HttpEntity<Customer> request = new HttpEntity<>(customer, headers);

        ResponseEntity<Customer> response = restTemplate.postForEntity(BASE_URL, request, Customer.class);
        return response.getBody(); // Deserialize response to Customer object
    }
}
