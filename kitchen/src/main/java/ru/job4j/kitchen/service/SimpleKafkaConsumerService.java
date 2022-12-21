package ru.job4j.kitchen.service;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Notification;
import ru.job4j.domain.model.Order;

@Service
@AllArgsConstructor
public class SimpleKafkaConsumerService implements KafkaConsumerService {

    private KitchenService simpleKitchenService;

    @KafkaListener(topics = {"kitchenNotification"})
    public void onApiCall(ConsumerRecord<Integer, Order> input) {
        Order order = input.value();
        System.out.println("заказ принят на кухне " + order);
        simpleKitchenService.ready(order);
    }
}
