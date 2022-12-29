package ru.job4j.notification.service;

import ru.job4j.domain.model.Notification;
import ru.job4j.domain.model.Order;

public interface NotificationService {

    void save(Notification notification);

    Notification createNotification(Order order);

    void sendMessageToCustomer(Notification notification);
}
