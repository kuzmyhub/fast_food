package ru.kitchen.controller;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.domain.model.Order;
import ru.kitchen.service.DishService;

@Service
@AllArgsConstructor
public class KafkaConsumerController {

    private DishService simpleDishService;

    @KafkaListener(topics = {"kitchenNotification"})
    public void onApiCall(ConsumerRecord<Integer, Order> input) throws InterruptedException {
        Order order = input.value();
        System.out.println("Заказ №" + order.getId() + " принят в сервисе кухни");
        simpleDishService.acceptOrder(order);
    }
}
