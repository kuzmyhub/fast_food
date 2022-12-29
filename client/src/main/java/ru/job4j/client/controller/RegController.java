package ru.job4j.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.client.repository.AuthorityRepository;
import ru.job4j.client.repository.UserRepository;
import ru.job4j.client.service.PrincipalService;
import ru.job4j.domain.model.User;

import java.security.Principal;

@Controller
@RequestMapping("/client/reg")
@AllArgsConstructor
public class RegController {

    private final PasswordEncoder encoder;
    private final UserRepository users;
    private final AuthorityRepository authorities;
    private PrincipalService simplePrincipalService;

    @PostMapping
    public String regSave(@ModelAttribute User user, Model model, Principal principal) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorities.findByAuthority("ROLE_USER"));
        try {
            users.save(user);
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
                simplePrincipalService.getUsername(principal));
        return "reg";
    }
}
