package ru.job4j.delivery.controller;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import ru.job4j.delivery.service.CourierService;
import ru.job4j.delivery.service.KafkaProducerService;
import ru.job4j.domain.model.Order;

@Controller
@AllArgsConstructor
public class KafkaConsumerController {

    private CourierService simpleCourierService;
    private KafkaProducerService simpleKafkaProducerService;

    @KafkaListener(topics = {"deliveryNotification"})
    public void onApiCall(ConsumerRecord<Integer, Order> input) throws InterruptedException {
        Order order = input.value();
        System.out.println("Заказ № " + order.getId() + " принят в сервисе доставки");
        simpleCourierService.setCourier(order);
        simpleKafkaProducerService.sendToOrder(order);
        simpleCourierService.deliverOrder(order);
        simpleKafkaProducerService.sendToOrder(order);
    }
}
