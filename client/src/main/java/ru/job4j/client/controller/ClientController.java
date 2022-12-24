package ru.job4j.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.client.service.DishService;

@Controller
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private DishService simpleDishService;

    @GetMapping
    public String home(Model model) {
        return "home";
    }
}
