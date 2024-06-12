package com.springBoot.tips.domain.specification;

import com.springBoot.tips.models.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;


public class AuthorSpecifications {
    public static Specification<Author> hasFirstName(String firstName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), firstName);
    }

    public static Specification<Author> hasAge(Integer age) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("age"), age);
    }
    public static Specification<Author> findByNameAndAge(String firstName, Integer age) {
        return Specification.where(hasFirstName(firstName)).and(hasAge(age));
    }

    }

