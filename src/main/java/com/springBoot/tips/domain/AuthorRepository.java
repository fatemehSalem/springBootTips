package com.springBoot.tips.domain;

import com.springBoot.tips.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author ,Long> {
}
