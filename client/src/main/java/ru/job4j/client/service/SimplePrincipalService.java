package ru.job4j.client.service;

import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class SimplePrincipalService implements PrincipalService {

    public String getUsername(Principal principal) {
        String username = "Гость";
        if (principal != null) {
            username = principal.getName();
        }
        return username;
    }
}
