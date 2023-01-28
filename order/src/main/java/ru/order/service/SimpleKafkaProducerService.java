package ru.order.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.domain.model.Order;

@Service
@AllArgsConstructor
public class SimpleKafkaProducerService implements KafkaProducerService {

    private KafkaTemplate<Integer, Order> template;

    public void sendToDelivery(Order order) {
        template.send("deliveryNotification", order);
        System.out.println("Заказ № " + order.getId() + " отправлен в сервис доставки");
    }

    public void sendOrderStatusNotification(Order order) {
        template.send("orderStatusNotification", order);
        System.out.println("Уведомление по заказу № " + order.getId() + " отправлено");
    }

    public void sendToKitchen(Order order) {
        template.send("kitchenNotification", order);
        System.out.println("Заказ № " + order.getId() + " отправлен на сервис кухни");
    }
}
