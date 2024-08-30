package com.springBoot.tips.domain.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SecurityAspect  {
    @Before("execution(* com.springBoot.tips.domain.service.*.*(..))")
    public void checkAuthorization() {
        // Simple authorization logic
        if (!isUserAuthorized()) {
            throw new SecurityException("User not authorized");
        }
    }
    private boolean isUserAuthorized() {
        // Dummy check; replace with real authorization logic
        return true; // Assume user is authorized for simplicity
    }
}
