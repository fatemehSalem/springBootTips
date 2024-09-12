package com.springBoot.tips.domain.config;

import com.springBoot.tips.domain.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public MyService myService() {
        return new MyService();                  // Factory method creates MyService instance
    }
}
