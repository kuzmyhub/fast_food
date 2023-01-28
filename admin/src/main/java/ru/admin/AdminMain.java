package ru.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.admin", "ru.domain.model"})
@EntityScan(basePackages = {"ru.domain.model"})
public class AdminMain {
    public static void main(String[] args) {
        SpringApplication.run(AdminMain.class, args);
        System.out.println("http://localhost:8100/admin/login");
    }
}
