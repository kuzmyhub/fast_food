package ru.job4j.client.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.client.repository.PaymentRepository;
import ru.job4j.domain.model.Payment;

@Service
@AllArgsConstructor
public class SimplePaymentService implements PaymentService {

    private PaymentRepository paymentAPIRepository;

    public Payment save(Payment payment) {
        return paymentAPIRepository.save(payment);
    }
}
