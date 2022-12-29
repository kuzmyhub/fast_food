package ru.job4j.client.service;

import java.security.Principal;

public interface PrincipalService {
    String getUsername(Principal principal);
}
