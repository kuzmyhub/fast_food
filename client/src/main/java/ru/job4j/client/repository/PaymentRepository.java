package ru.job4j.client.repository;

import ru.job4j.domain.model.Payment;

public interface PaymentRepository {
    Payment save(Payment payment);
}
