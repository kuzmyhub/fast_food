package ru.admin.service;

import ru.domain.model.Customer;

import java.security.Principal;

public interface CustomerService {

    String getUsername(Principal principal);

    Customer findCustomerByUsername(String username);
}
