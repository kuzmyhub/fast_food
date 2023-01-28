package ru.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.domain.model", "ru.notification"})
@EntityScan(basePackages = {"ru.domain.model"})
public class NotificationMain {
    public static void main(String[] args) {
        SpringApplication.run(NotificationMain.class, args);
    }
}
