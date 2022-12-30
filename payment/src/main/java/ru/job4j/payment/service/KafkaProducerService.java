package ru.job4j.payment.service;

import ru.job4j.domain.model.Payment;

public interface KafkaProducerService {

    void sendPaymentStatusNotification(Payment payment);
}
