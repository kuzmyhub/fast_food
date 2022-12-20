package ru.job4j.dish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.job4j.domain.model", "ru.job4j.dish"})
@EntityScan(basePackages = "ru.job4j.domain.model")
public class DishMain {
    public static void main(String[] args) {
        SpringApplication.run(DishMain.class, args);
    }
}
