package ru.client.repository;

import ru.domain.model.Payment;

public interface PaymentRepository {
    Payment save(Payment payment);
}
