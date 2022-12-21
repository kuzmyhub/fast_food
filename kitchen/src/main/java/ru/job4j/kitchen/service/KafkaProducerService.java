package ru.job4j.kitchen.service;

import ru.job4j.domain.model.Order;

public interface KafkaProducerService {

    void sendToOrder(Order order);
}
