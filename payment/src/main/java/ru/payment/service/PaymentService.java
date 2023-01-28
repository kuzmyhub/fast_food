package ru.payment.service;

import ru.domain.model.Payment;

public interface PaymentService {
    Payment save(Payment payment);
}
