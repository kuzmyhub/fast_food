package ru.order.service;

import ru.domain.model.Card;
import ru.domain.model.Customer;

import java.util.Optional;

public interface CardService {
    Card buyCard(Card card);

    Optional<Card> findCardByCustomer(Customer customer);
}
