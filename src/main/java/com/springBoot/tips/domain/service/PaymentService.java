package com.springBoot.tips.domain.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentStrategy creditCardPayment;
    private final PaymentStrategy payPalPayment;
    private final PaymentStrategy bankTransferPayment;

    @Autowired
    public PaymentService(@Qualifier("creditCardPayment") PaymentStrategy creditCardPayment,
                          @Qualifier("payPalPayment") PaymentStrategy payPalPayment,
                          @Qualifier("bankTransferPayment") PaymentStrategy bankTransferPayment) {
        this.creditCardPayment = creditCardPayment;
        this.payPalPayment = payPalPayment;
        this.bankTransferPayment = bankTransferPayment;
    }

    public void processPayment(String method, double amount) {
        switch (method) {
            case "CreditCard" -> creditCardPayment.pay(amount);
            case "PayPal" -> payPalPayment.pay(amount);
            case "BankTransfer" -> bankTransferPayment.pay(amount);
            default -> throw new IllegalArgumentException("Payment method not supported");
        }
    }
}
