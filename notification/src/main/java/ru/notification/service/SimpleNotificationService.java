package ru.notification.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.domain.model.Notification;
import ru.domain.model.Order;
import ru.domain.model.Payment;
import ru.domain.model.Status;
import ru.notification.repository.NotificationRepository;

@Service
@AllArgsConstructor
public class SimpleNotificationService implements NotificationService {

    private NotificationRepository notificationRepository;

    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification createOrderStatusNotification(Order order) {
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

    public Notification createPaymentStatusNotification(Payment payment) {
        Notification notification = new Notification();
        notification.setOrderNumber(payment.getOrder().getId());
        notification.setStatus(Status.PAID);
        notification.setDescription(
                String.format(
                        "Статус оплаты заказа №%s на сумму %s: %s",
                        payment.getOrder().getId(),
                        payment.getOrder().getAmount(),
                        notification.getStatus()
                )
        );
        return notification;
    }

    public void sendNotificationToCustomer(Notification notification) {
        System.out.println(notification);
        /*
        Логика отправки уведомления
        */
    }
}
