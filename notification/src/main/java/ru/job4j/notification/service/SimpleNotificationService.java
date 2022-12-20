package ru.job4j.notification.service;

import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Not;
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
        notification.setStatus("Принят");
        notification.setDescription(
                String.format(
                        "Заказ %s на сумму %s принят в обработку",
                        order.getId(),
                        order.getAmount()
                )
        );
        return notification;
    }
}
