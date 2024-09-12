package com.springBoot.tips.rest;

import com.springBoot.tips.domain.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public ResponseEntity<String> pay(@RequestParam String method, @RequestParam double amount) {
        paymentService.processPayment(method, amount);
        return ResponseEntity.ok("Payment processed using " + method);
    }
}
