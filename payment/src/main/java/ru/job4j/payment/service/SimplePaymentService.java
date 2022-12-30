package ru.job4j.payment.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Payment;
import ru.job4j.payment.repository.PaymentRepository;

@Service
@AllArgsConstructor
public class SimplePaymentService implements PaymentService {

    private PaymentRepository paymentRepository;

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }
}
