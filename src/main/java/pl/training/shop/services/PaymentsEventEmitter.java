package pl.training.shop.services;

import pl.training.shop.entities.Payment;

public interface PaymentsEventEmitter {

    void emit(Payment payment);

}
