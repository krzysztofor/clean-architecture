package pl.training.shop.services;

import lombok.RequiredArgsConstructor;
import pl.training.shop.entities.Payment;
import pl.training.shop.entities.PaymentRequest;
import pl.training.shop.entities.PaymentStatus;
import pl.training.shop.repositories.PaymentsRepository;

@RequiredArgsConstructor
public class PaymentService implements Payments {

    private final PaymentIdGenerator paymentIdGenerator;
    private final PaymentsRepository paymentsRepository;
    private final PaymentsEventEmitter paymentsEventEmitter;
    private final TimeProvider timeProvider;

    @Override
    public Payment process(PaymentRequest paymentRequest) {
        var payment = createPayment(paymentRequest);
        // Integration with external payments gateway
        paymentsEventEmitter.emit(payment);
        return paymentsRepository.save(payment);
    }

    private Payment createPayment(PaymentRequest paymentRequest) {
        return Payment.builder()
                .id(paymentIdGenerator.getNext())
                .value(paymentRequest.getValue())
                .properties(paymentRequest.getProperties())
                .timestamp(timeProvider.getTimestamp())
                .status(PaymentStatus.STARTED)
                .build();
    }

    @Override
    public Payment findById(String id) {
        return paymentsRepository.findById(id)
                .orElseThrow(PaymentNotFoundException::new);
    }

}
