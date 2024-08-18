package com.springBoot.tips.rest;

import com.springBoot.tips.domain.CustomerNotFoundException;
import com.springBoot.tips.models.Customer;
import com.springBoot.tips.domain.service.CustomerService;
import com.springBoot.tips.models.CustomerPatchRequest;
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
    public List<Customer> getCustomersByStatus(@RequestParam String name,
                                               @RequestParam String email) {
        return customerService.getCustomerByNameAndEmail(name, email);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id,
                                   @RequestBody Customer updatedCustomer) {
        return customerService.findById(id).map(customer -> {
            customerService.save(updatedCustomer);
            return updatedCustomer;
        }).orElseThrow(() -> {
            throw  new CustomerNotFoundException(id);
        });
    }

    @PatchMapping("/patchCustomer")
    public Customer patchCustomer(@RequestBody CustomerPatchRequest request) {
        return customerService.findById(request.id())
                .map(customer -> {
                    if (request.name() != null)
                        customer.setName(request.name());

                    if (request.email() != null)
                        customer.setEmail(request.email());
                    customerService.save(customer);
                    return customer;
                }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
