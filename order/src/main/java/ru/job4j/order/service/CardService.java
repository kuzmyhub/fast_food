package ru.job4j.order.service;

import ru.job4j.domain.model.Card;
import ru.job4j.domain.model.Customer;

import java.util.Optional;

public interface CardService {
    Card buyCard(Card card);

    Optional<Card> findCardByCustomer(Customer customer);
}
