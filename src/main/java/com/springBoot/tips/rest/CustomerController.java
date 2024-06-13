package com.springBoot.tips.rest;

import com.springBoot.tips.models.Customer;
import com.springBoot.tips.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/getAll")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody @Valid Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getCustomersByStatus(@RequestParam String name, @RequestParam String email) {
        return customerService.getCustomerByNameAndEmail(name, email);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id,
                                   @RequestBody Customer updatedCustomer) {
        return customerService.findById(id).map(customer -> {
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
             customerService.save(customer);
            return customer;
        }).orElseGet(() -> {
            updatedCustomer.setId(id);
             customerService.save(updatedCustomer);
             return updatedCustomer;
        });
    }

    @PatchMapping("/{id}")
    public Customer patchCustomer(@PathVariable Long id,
                                  @RequestBody Map<String, Object> updates) {
        return customerService.findById(id).map(customer -> {
            updates.forEach((key, value) -> {
                switch (key) {
                    case "name" -> customer.setName((String) value);
                    case "email" -> customer.setEmail((String) value);
                    default -> throw new IllegalArgumentException("Invalid field: " + key);
                }
            });
             customerService.save(customer);
             return customer;
        }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
