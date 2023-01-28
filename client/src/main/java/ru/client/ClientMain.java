package ru.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.domain.model", "ru.client"})
@EntityScan(basePackages = {"ru.domain.model"})
public class ClientMain {
    public static void main(String[] args) {
        SpringApplication.run(ClientMain.class, args);
        System.out.println("http://localhost:8090/client/login");
        System.out.println("log: admin");
        System.out.println("pas: password");
    }
}