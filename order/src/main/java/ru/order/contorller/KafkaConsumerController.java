package ru.order.contorller;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import ru.domain.model.Order;
import ru.order.service.KafkaProducerService;
import ru.order.service.OrderService;

@Controller
@AllArgsConstructor
public class KafkaConsumerController {

    private OrderService simpleOrderService;
    private KafkaProducerService simpleKafkaProducerService;

    @KafkaListener(topics = {"orderNotification"})
    public void onApiCallKitchen(ConsumerRecord<Integer, Order> input) {
        Order order = input.value();
        System.out.println("Заказ № " + order.getId() + " принят с сервиса кухни");
        simpleOrderService.createOrder(order);
        simpleKafkaProducerService.sendOrderStatusNotification(order);
        simpleKafkaProducerService.sendToDelivery(order);
    }

    @KafkaListener(topics = {"orderNotificationFromDelivery"})
    public void onApiCallDelivery(ConsumerRecord<Integer, Order> input) {
        Order order = input.value();
        System.out.println("Заказ № " + order.getId() + " принят с сервиса доставки");
        simpleOrderService.createOrder(order);
        simpleKafkaProducerService.sendOrderStatusNotification(order);
    }
}
