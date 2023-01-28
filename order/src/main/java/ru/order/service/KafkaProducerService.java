package ru.order.service;

import ru.domain.model.Order;

public interface KafkaProducerService {

    void sendToDelivery(Order order);

    void sendOrderStatusNotification(Order order);

    void sendToKitchen(Order order);
}
