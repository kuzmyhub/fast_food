package ru.job4j.admin.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.admin.service.CustomerService;
import ru.job4j.admin.service.DishService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private CustomerService simpleCustomerService;

    @GetMapping
    public String home(Model model, Principal principal) {
        model.addAttribute("username",
                simpleCustomerService.getUsername(principal));
        return "home";
    }
}
