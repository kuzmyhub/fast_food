package ru.delivery.controller;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import ru.delivery.service.CourierService;
import ru.delivery.service.KafkaProducerService;
import ru.domain.model.Order;

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
