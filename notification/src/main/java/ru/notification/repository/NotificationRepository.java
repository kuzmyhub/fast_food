package ru.notification.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.domain.model.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Integer> {

}
