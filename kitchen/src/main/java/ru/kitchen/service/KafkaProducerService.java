package ru.kitchen.service;

import ru.domain.model.Order;

public interface KafkaProducerService {

    void sendToOrder(Order order);
}
