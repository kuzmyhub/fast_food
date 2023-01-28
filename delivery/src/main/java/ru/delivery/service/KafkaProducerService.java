package ru.delivery.service;

import ru.domain.model.Order;

public interface KafkaProducerService {

    public void sendToOrder(Order order);
}
