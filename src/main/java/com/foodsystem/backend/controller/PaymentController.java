package com.foodsystem.backend.controller;

import com.foodsystem.backend.entity.Payment;
import com.foodsystem.backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/process")
    public Payment processPayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }
}