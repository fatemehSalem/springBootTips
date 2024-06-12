package com.springBoot.tips.domain;

import com.springBoot.tips.models.Customer;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecifications {

    public static Specification<Customer> hasName(String name) {

        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }
}