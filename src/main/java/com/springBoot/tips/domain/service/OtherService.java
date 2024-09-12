package com.springBoot.tips.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class OtherService {
    @Transactional
    public void methodB() {
        // ... some code here
    }
}
