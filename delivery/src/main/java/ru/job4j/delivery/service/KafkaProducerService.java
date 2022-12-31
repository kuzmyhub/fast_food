package ru.job4j.delivery.service;

import ru.job4j.domain.model.Order;

public interface KafkaProducerService {

    public void sendToOrder(Order order);
}
