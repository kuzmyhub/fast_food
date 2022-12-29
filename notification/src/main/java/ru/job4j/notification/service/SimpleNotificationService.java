package ru.job4j.notification.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Notification;
import ru.job4j.domain.model.Order;
import ru.job4j.notification.repository.NotificationRepository;

@Service
@AllArgsConstructor
public class SimpleNotificationService implements NotificationService {

    private NotificationRepository notificationRepository;

    public void save(Notification notification) {
        notificationRepository.save(notification);
    }

    public Notification createNotification(Order order) {
        Notification notification = new Notification();
        notification.setOrderNumber(order.getId());
        notification.setStatus(order.getStatus());
        notification.setDescription(
                String.format(
                        "Статус вашего заказа №%s на сумму %s: %s",
                        order.getId(),
                        order.getAmount(),
                        order.getStatus()
                )
        );
        return notification;
    }

    public void sendMessageToCustomer(Notification notification) {
        System.out.println(notification);
        /*
        Логика отправки сообщения на телефон/mail
        */
    }
}
