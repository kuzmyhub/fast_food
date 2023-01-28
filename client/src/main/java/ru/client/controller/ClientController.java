package ru.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.client.service.CustomerService;

import java.security.Principal;

@Controller
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private CustomerService simpleCustomerService;

    @GetMapping
    public String home(Model model, Principal principal) {
        model.addAttribute("username",
                simpleCustomerService.getUsername(principal));
        return "home";
    }
}
