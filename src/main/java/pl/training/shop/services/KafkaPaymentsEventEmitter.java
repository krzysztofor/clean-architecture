package pl.training.shop.services;

import lombok.extern.java.Log;
import pl.training.shop.entities.Payment;

@Log
public class KafkaPaymentsEventEmitter implements PaymentsEventEmitter {

    @Override
    public void emit(Payment payment) {
        log.info("Emitting payment event...");
    }

}
