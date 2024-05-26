package com.springBoot.tips.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Customer")*/
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long customerId) {
        super("Customer with id = " + customerId + " not found");
    }
}