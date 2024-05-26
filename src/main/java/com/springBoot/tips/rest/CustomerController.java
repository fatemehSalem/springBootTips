package com.springBoot.tips.rest;

import com.springBoot.tips.domain.Customer;
import com.springBoot.tips.domain.CustomerNotFoundException;
import com.springBoot.tips.domain.CustomerService;
import com.springBoot.tips.domain.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(CustomerNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
