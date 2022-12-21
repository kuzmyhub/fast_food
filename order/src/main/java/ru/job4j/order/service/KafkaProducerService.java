package ru.job4j.order.service;

import ru.job4j.domain.model.Order;

public interface KafkaProducerService {

    void send(Order order);

    void sendToKitchen(Order order);
}
