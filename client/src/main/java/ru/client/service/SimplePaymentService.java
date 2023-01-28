package ru.client.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.client.repository.PaymentRepository;
import ru.domain.model.Payment;

@Service
@AllArgsConstructor
public class SimplePaymentService implements PaymentService {

    private PaymentRepository paymentAPIRepository;

    public Payment save(Payment payment) {
        return paymentAPIRepository.save(payment);
    }
}
