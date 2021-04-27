package pl.training.shop;

import lombok.extern.java.Log;
import pl.training.shop.commons.LocalMoney;
import pl.training.shop.services.SystemTimeProvider;
import pl.training.shop.entities.PaymentRequest;
import pl.training.shop.repositories.InMemoryPaymentRepository;
import pl.training.shop.services.PaymentService;
import pl.training.shop.services.PaymentsLoggingProxy;
import pl.training.shop.services.UUIDPaymentIdGenerator;

import static java.util.Collections.emptyMap;

@Log
public class Application {

    public static void main(String[] args) {
        var paymentService = new PaymentService(new UUIDPaymentIdGenerator(), new InMemoryPaymentRepository(), new SystemTimeProvider());
        var payments = new PaymentsLoggingProxy(paymentService);
        var paymentRequest = new PaymentRequest(LocalMoney.of(1_000), emptyMap());
        var payment = payments.process(paymentRequest);
        log.info(payment.toString());
    }

}
