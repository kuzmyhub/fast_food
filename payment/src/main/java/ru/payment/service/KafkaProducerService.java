package ru.payment.service;

import ru.domain.model.Payment;

public interface KafkaProducerService {

    void sendPaymentStatusNotification(Payment payment);
}
