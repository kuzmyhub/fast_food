package ru.job4j.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.job4j.domain.model", "ru.job4j.delivery"})
@EntityScan(basePackages = {"ru.job4j.domain.model"})
public class DeliveryMain {
    public static void main(String[] args) {
        SpringApplication.run(DeliveryMain.class, args);
    }
}
