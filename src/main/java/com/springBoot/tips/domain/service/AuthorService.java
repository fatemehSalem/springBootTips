package com.springBoot.tips.domain.service;

import com.springBoot.tips.domain.AuthorNameAndAge;
import com.springBoot.tips.domain.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {
    private AuthorRepository authorRepository;

    public List<AuthorNameAndAge> findAuthorsByAge(Integer age) {
        return authorRepository.findAuthorsByAge(age);
    }

}
