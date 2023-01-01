package ru.job4j.admin.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.admin.repository.CustomerRepository;
import ru.job4j.domain.model.Customer;

import java.security.Principal;

@Service
@AllArgsConstructor
public class SimpleCustomerService implements CustomerService {

    private CustomerRepository customerRepository;

    public String getUsername(Principal principal) {
        String username = "Гость";
        if (principal != null) {
            username = principal.getName();
        }
        return username;
    }

    public Customer findCustomerByUsername(String username) {
        return customerRepository.findByUsername(username);
    }
}
