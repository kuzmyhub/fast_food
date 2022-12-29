package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Order;

@Service
@AllArgsConstructor
public class SimpleKafkaProducerService implements KafkaProducerService {

    private KafkaTemplate<Integer, Order> template;

    public void sendNotification(Order order) {
        template.send("notification", order);
        System.out.println("Уведомление отправлено " + order.getAddress());
    }

    public void sendToKitchen(Order order) {
        template.send("kitchenNotification", order);
        System.out.println("Заказ отправлен на кухню " + order.getAddress());
    }
}
