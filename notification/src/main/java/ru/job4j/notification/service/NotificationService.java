package ru.job4j.notification.service;

import ru.job4j.domain.model.Notification;
import ru.job4j.domain.model.Order;
import ru.job4j.domain.model.Payment;

public interface NotificationService {

    Notification save(Notification notification);

    Notification createOrderStatusNotification(Order order);

    Notification createPaymentStatusNotification(Payment payment);

    void sendNotificationToCustomer(Notification notification);
}
