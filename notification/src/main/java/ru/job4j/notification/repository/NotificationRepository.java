package ru.job4j.notification.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Notification;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NotificationRepository {

    private final List<Notification> notifications = new ArrayList<>();

    public void save(Notification notification) {
        notifications.add(notification);
        System.out.println(notification);
    }
}
