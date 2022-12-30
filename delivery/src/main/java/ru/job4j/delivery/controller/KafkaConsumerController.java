package ru.job4j.delivery.controller;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import ru.job4j.domain.model.Order;

@Controller
@AllArgsConstructor
public class KafkaConsumerController {

    @KafkaListener(topics = {"deliveryNotification"})
    public void onApiCall(ConsumerRecord<Integer, Order> input) throws InterruptedException {
        Order order = input.value();
        System.out.println("Заказ принят в доставке " + order.getAddress());
    }
}
