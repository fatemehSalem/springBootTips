package com.springBoot.tips.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {
     @Autowired
    private MyService self;

    @Transactional
    public void methodA() {
        // ... some code here
        self.methodB();
        // ... some code here
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodB() {
        // ... some code here
    }






/*    @Transactional
    public void methodA() {
        System.out.println("Inside methodA");
        this.methodB();  // Direct internal call using 'this'
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodB() {
        System.out.println("Inside methodB");
        // Should start a new transaction, but it won't due to direct call
    }*/


/*
    @Transactional
    public void methodA() {
        System.out.println("Inside methodA");
        privateMethod();  // Direct internal call to a private method
    }

    @Transactional
    void privateMethod() {
        System.out.println("Inside privateMethod");
        // This method's transactional behavior is ignored
    }
*/






/*    @Transactional
    public void methodA() {
        System.out.println("Inside methodA");
        methodC();  // Direct internal call to methodC
    }

    @Transactional(propagation = Propagation.NEVER)
    public void methodC() {
        System.out.println("Inside methodC");
        // Should throw an exception if called within a transaction, but it won't
    }*/


/*    @Transactional
    public void methodA() {
        System.out.println("Inside methodA");
        if (someCondition()) {
            methodB();  // Direct internal call based on a condition
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodB() {
        System.out.println("Inside methodB");
        // Should start a new transaction, but it won't due to direct call
    }

    private boolean someCondition() {
        return true;  // Just an example condition
    }*/


/*    @Autowired
    private OtherService otherService;

    @Transactional
    public void methodA() {
        // ... some code here
        otherService.methodB();
        // ... some code here
    }






   /* */
 /*   @Transactional
    public void methodA() {
        // ... some code here
        methodB();
        // ... some code here
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodB() {
        // ... some code here
    }*/
}
