package pl.training.shop.services;

import pl.training.shop.entities.Payment;
import pl.training.shop.entities.PaymentRequest;

public interface Payments {

    Payment process(PaymentRequest paymentRequest);

    Payment findById(String id);

}
