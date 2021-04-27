package pl.training.shop.repositories;

import pl.training.shop.entities.Payment;

import java.util.Optional;

public interface PaymentRepository {

    Payment save(Payment payment);

    Optional<Payment> findById(String id);

}
