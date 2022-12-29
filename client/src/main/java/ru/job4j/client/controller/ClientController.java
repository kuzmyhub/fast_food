package ru.job4j.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.client.service.DishService;
import ru.job4j.client.service.PrincipalService;

import java.security.Principal;

@Controller
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private PrincipalService simplePrincipalService;

    @GetMapping
    public String home(Model model, Principal principal) {
        model.addAttribute("username",
                simplePrincipalService.getUsername(principal));
        return "home";
    }
}
