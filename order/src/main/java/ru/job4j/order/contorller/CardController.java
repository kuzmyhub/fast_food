package ru.job4j.order.contorller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.domain.model.Card;
import ru.job4j.domain.model.Customer;
import ru.job4j.order.service.CardService;

@RestController
@AllArgsConstructor
@RequestMapping("/card")
public class CardController {

    private CardService simpleCardService;

    @PostMapping
    public ResponseEntity<Card> buyCard(Card card) {
        return new ResponseEntity<>(
                simpleCardService.buyCard(card),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<Card> findCardByCustomer(
            @RequestBody Customer customer
    ) {
        Card card = simpleCardService.findCardByCustomer(customer)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Card is missing"
                        )
                );
        return new ResponseEntity<>(card, HttpStatus.OK);
    }
}
