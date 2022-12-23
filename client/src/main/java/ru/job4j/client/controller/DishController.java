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
public class DishController {

    private DishService simpleDishService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("dishes", simpleDishService.findAll());
        return "home";
    }
}
