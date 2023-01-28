package ru.client.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.client.repository.CustomerRepository;
import ru.domain.model.Customer;

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
