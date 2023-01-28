package ru.delivery.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.domain.model.Order;

@Service
@AllArgsConstructor
public class SimpleKafkaProducerService implements KafkaProducerService {

    private KafkaTemplate<Integer, Order> template;

    public void sendToOrder(Order order) {
        template.send("orderNotificationFromDelivery", order);
        System.out.println("Заказ № " + order.getId() + " отправлен из сервиса доставки");
    }
}
