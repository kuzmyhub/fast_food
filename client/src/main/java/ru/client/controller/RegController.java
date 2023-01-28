package ru.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.client.repository.AuthorityRepository;
import ru.client.repository.CustomerRepository;
import ru.client.service.CustomerService;
import ru.domain.model.Customer;

import java.security.Principal;

@Controller
@RequestMapping("/client/reg")
@AllArgsConstructor
public class RegController {

    private final PasswordEncoder encoder;
    private final CustomerRepository customerRepository;
    private final AuthorityRepository authorityRepository;
    private CustomerService simpleCustomerService;

    @PostMapping
    public String regSave(@ModelAttribute Customer customer, Model model) {
        customer.setEnabled(true);
        customer.setPassword(encoder.encode(customer.getPassword()));
        customer.setAuthority(authorityRepository.findByAuthority("ROLE_USER"));
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            model.addAttribute("errorMessage",
                    "Username already exists");
            return "reg";
        }
        return "redirect:/client/login";
    }

    @GetMapping
    public String regPage(Model model, Principal principal) {
        model.addAttribute("username",
                simpleCustomerService.getUsername(principal));
        return "reg";
    }
}
