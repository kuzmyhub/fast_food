package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.Card;
import ru.job4j.Customer;

import java.util.Optional;

public interface CardService {
    Card buyCard(Card card);

    Optional<Card> findCardByCustomer(Customer customer);
}
