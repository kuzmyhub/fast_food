package ru.job4j.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.job4j.domain.model", "ru.job4j.client"})
@EntityScan(basePackages = {"ru.job4j.domain.model"})
public class ClientMain {
    public static void main(String[] args) {
        SpringApplication.run(ClientMain.class, args);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String psw = encoder.encode("password");
        System.out.println(psw);
        System.out.println("http://localhost:8090/client/login");
    }
}