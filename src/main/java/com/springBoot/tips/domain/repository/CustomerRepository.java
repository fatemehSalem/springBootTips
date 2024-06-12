package com.springBoot.tips.domain.repository;

import com.springBoot.tips.models.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    @Transactional
    @Modifying
    @Query("update Customer  c set c.name =: name")
    void updateCustomer(Long id, String name);
}