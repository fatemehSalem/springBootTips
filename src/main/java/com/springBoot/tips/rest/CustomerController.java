package com.springBoot.tips.rest;

import com.springBoot.tips.domain.Customer;
import com.springBoot.tips.domain.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
        System.out.println("--------CustomerController()---------");
    }

    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
