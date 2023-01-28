package ru.kitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.domain.model", "ru.kitchen"})
@EntityScan(basePackages = {"ru.domain.model"})
public class KitchenMain {
    public static void main(String[] args) {
        SpringApplication.run(KitchenMain.class, args);
    }
}
