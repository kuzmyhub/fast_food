package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Card;
import ru.job4j.domain.model.Customer;
import ru.job4j.order.repository.CardRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleCardService implements CardService {

    private CardRepository cardRepository;

    public Card buyCard(Card card) {
        return cardRepository.save(card);
    }

    public Optional<Card> findCardByCustomer(Customer customer) {
        return cardRepository.findByCustomer(customer);
    }
}
