package ru.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.domain.model.Card;
import ru.domain.model.Customer;

import java.util.Optional;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {
    Optional<Card> findByCustomer(Customer customer);
}
