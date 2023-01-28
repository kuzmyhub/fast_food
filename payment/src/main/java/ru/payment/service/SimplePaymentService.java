package ru.payment.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.domain.model.Payment;
import ru.payment.repository.PaymentRepository;

@Service
@AllArgsConstructor
public class SimplePaymentService implements PaymentService {

    private PaymentRepository paymentRepository;

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }
}
