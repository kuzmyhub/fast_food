package ru.job4j.notification.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Integer> {

}
