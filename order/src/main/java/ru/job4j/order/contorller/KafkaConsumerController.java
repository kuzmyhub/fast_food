package ru.job4j.order.contorller;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import ru.job4j.domain.model.Customer;
import ru.job4j.domain.model.Order;
import ru.job4j.order.repository.CustomerRepository;
import ru.job4j.order.service.KafkaProducerService;
import ru.job4j.order.service.OrderService;

@Controller
@AllArgsConstructor
public class KafkaConsumerController {

    private OrderService simpleOrderService;
    private KafkaProducerService simpleKafkaProducerService;

    @KafkaListener(topics = {"orderNotification"})
    public void onApiCall(ConsumerRecord<Integer, Order> input) {
        Order order = input.value();
        System.out.println("Заказ принят с кухни " + order.getAddress());
        simpleOrderService.createOrder(order);
        simpleKafkaProducerService.sendOrderStatusNotification(order);
        simpleKafkaProducerService.sendToDelivery(order);
    }
}
