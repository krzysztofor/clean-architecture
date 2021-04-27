package pl.training.shop.controllers;

import lombok.RequiredArgsConstructor;
import pl.training.shop.entities.Payment;
import pl.training.shop.entities.PaymentRequest;
import pl.training.shop.services.Payments;

@RequiredArgsConstructor
public class PaymentsController {

    private final Payments payments;

    public Payment processPayment(PaymentRequest paymentRequest) {
        return payments.process(paymentRequest);
    }

    public Payment findById(String paymentId) {
        return payments.findById(paymentId);
    }

}
