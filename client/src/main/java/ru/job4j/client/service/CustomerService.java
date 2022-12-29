package ru.job4j.client.service;

import ru.job4j.domain.model.Customer;

import java.security.Principal;

public interface CustomerService {
    String getUsername(Principal principal);

    Customer findCustomerByUsername(String username);
}
