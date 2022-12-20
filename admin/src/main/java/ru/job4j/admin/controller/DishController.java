package ru.job4j.admin.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.dish.service.DishService;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class DishController {

    private DishService simpleDishService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("dishes", simpleDishService.findAll());
        return "home";
    }
}
