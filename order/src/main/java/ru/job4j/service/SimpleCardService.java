package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.Card;
import ru.job4j.Customer;
import ru.job4j.repository.CardRepository;

import java.util.Optional;

@Service
public class SimpleCardService implements CardService {

    private CardRepository cardRepository;

    public Card buyCard(Card card) {
        return cardRepository.save(card);
    }

    public Optional<Card> findCardByCustomer(Customer customer) {
        return cardRepository.findByCustomer(customer);
    }
}
