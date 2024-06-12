package com.springBoot.tips.domain.repository;

import com.springBoot.tips.domain.AuthorNameAndAge;
import com.springBoot.tips.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author ,Long>, JpaSpecificationExecutor<Author> {
    @Query("SELECT a.firstName AS firstName, a.age AS age FROM Author a WHERE a.age = :age and a.firstName =: firstName")
    List<AuthorNameAndAge> findByNameAndAge(@Param("age") Integer age, @Param("firstName") String firstName);

    @Query("SELECT new com.springBoot.tips.domain.AuthorNameAndAge(a.firstName, a.age) FROM Author a WHERE a.age = ?1")
    List<AuthorNameAndAge> findAuthorsByAge(Integer age);
}
