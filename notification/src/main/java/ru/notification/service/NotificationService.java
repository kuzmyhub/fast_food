package ru.notification.service;

import ru.domain.model.Notification;
import ru.domain.model.Order;
import ru.domain.model.Payment;

public interface NotificationService {

    Notification save(Notification notification);

    Notification createOrderStatusNotification(Order order);

    Notification createPaymentStatusNotification(Payment payment);

    void sendNotificationToCustomer(Notification notification);
}
