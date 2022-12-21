package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Notification;
import ru.job4j.domain.model.Order;

@Service
@AllArgsConstructor
public class SimpleKafkaProducerService implements KafkaProducerService {

    private KafkaTemplate<Integer, Order> template;

    public void send(Order order) {
        System.out.println("пре" + order);
        template.send("notification", order);
        System.out.println("пост" + order);
    }

    public void sendToKitchen(Order order) {
        template.send("kitchenNotification", order);
        System.out.println("заказ отправлен из заказа " + order);
    }
}
