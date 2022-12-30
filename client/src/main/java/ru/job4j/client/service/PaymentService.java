package ru.job4j.client.service;

import ru.job4j.domain.model.Payment;

public interface PaymentService {

    Payment save(Payment payment);
}
