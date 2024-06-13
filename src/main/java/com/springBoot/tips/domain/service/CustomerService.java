package com.springBoot.tips.domain.service;

import com.springBoot.tips.domain.CustomerNotFoundException;
import com.springBoot.tips.domain.specification.CustomerSpecifications;
import com.springBoot.tips.domain.repository.CustomerRepository;
import com.springBoot.tips.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }
    public List<Customer> getCustomerByNameAndEmail(String name, String email) {
        return customerRepository.findAll(CustomerSpecifications.getCustomerByNameAndEmail(name,email));
    }

    public Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }

    public void save(Customer customer){
        customerRepository.save(customer);
    }
}
