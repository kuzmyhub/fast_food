package ru.job4j.kitchen.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Order;

@Service
@AllArgsConstructor
public class SimpleKafkaProducerService implements KafkaProducerService {

    private KafkaTemplate<Integer, Order> template;

    public void sendToOrder(Order order) {
        template.send("orderNotification", order);
        System.out.println("Заказ № " + order.getId() + " отправлен с сервиса кухни");
    }

}
