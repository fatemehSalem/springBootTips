package com.springBoot.tips.domain;

import com.springBoot.tips.models.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Transactional
    @Modifying
    @Query("update Customer  c set c.name =: name")
    void updateCustomer(Long id, String name);
}