package ru.job4j.order.service;

import ru.job4j.domain.model.Order;

public interface KafkaProducerService {

    void sendToDelivery(Order order);

    void sendOrderStatusNotification(Order order);

    void sendToKitchen(Order order);
}
