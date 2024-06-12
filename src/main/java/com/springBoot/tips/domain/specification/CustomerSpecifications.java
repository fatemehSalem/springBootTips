package com.springBoot.tips.domain.specification;

import com.springBoot.tips.models.Customer;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecifications {

    private static Specification<Customer> hasName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }

    private static Specification<Customer> hasEmail(String email) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), email);
    }

    public static Specification<Customer> getCustomerByNameAndEmail(String name, String email){
        return Specification.where(hasName(name)).and(hasEmail(email));
    }
}