package ru.notification.controller;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.domain.model.Notification;
import ru.domain.model.Order;
import ru.domain.model.Payment;
import ru.notification.service.NotificationService;

@Service
@AllArgsConstructor
public class KafkaConsumerController {

    private NotificationService simpleNotificationService;

    @KafkaListener(topics = {"orderStatusNotification"})
    public void onApiCallOrder(ConsumerRecord<Integer, Order> input) {
        Order order = input.value();
        Notification notification = simpleNotificationService
                .createOrderStatusNotification(order);
        Notification savedNotification = simpleNotificationService.save(notification);
        simpleNotificationService.sendNotificationToCustomer(savedNotification);
    }

    @KafkaListener(topics = {"paymentStatusNotification"})
    public void onApiCallPayment(ConsumerRecord<Integer, Payment> input) {
        Payment payment = input.value();
        Notification notification = simpleNotificationService
                .createPaymentStatusNotification(payment);
        Notification savedNotification = simpleNotificationService.save(notification);
        simpleNotificationService.sendNotificationToCustomer(savedNotification);
    }
}
