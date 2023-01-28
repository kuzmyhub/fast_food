package ru.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.domain.model.Card;
import ru.domain.model.Customer;
import ru.order.repository.CardRepository;

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
