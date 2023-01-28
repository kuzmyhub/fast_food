package ru.dish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.domain.model", "ru.dish"})
@EntityScan(basePackages = "ru.domain.model")
public class DishMain {
    public static void main(String[] args) {
        SpringApplication.run(DishMain.class, args);
    }
}
