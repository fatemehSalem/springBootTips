package com.springBoot.tips.domain;

import com.springBoot.tips.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

interface CustomerRepository extends JpaRepository<Customer, Long> {
}