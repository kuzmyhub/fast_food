package ru.job4j.contorller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.Card;
import ru.job4j.Customer;
import ru.job4j.service.CardService;

@RestController
@AllArgsConstructor
public class CardController {

    private CardService simpleCardService;

    @PostMapping("/card")
    public ResponseEntity<Card> buyCard(Card card) {
        return new ResponseEntity<>(
                simpleCardService.buyCard(card),
                HttpStatus.OK
        );
    }

    @GetMapping("/card")
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
