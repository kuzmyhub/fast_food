package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Notification;
import ru.job4j.domain.model.Order;

@Service
@AllArgsConstructor
public class SimpleKafkaConsumerService implements KafkaConsumerService {

    private OrderService simpleOrderService;

    @KafkaListener(topics = {"orderNotification"})
    public void onApiCall(ConsumerRecord<Integer, Order> input) {
        Order order = input.value();
        System.out.println("Заказ принят с кухни " + order);
        simpleOrderService.createOrder(order);
    }
}
