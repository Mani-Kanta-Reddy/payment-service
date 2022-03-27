package com.neon.paymentservice.payment;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public Payment doPayment(Payment payment) {
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setStatus(processingPayment());
        return repository.save(payment);
    }

    private String processingPayment() {
        return new Random().nextBoolean() ? "success" : "fail";
    }
}
