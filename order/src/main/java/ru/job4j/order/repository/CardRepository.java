package ru.job4j.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Card;
import ru.job4j.domain.model.Customer;

import java.util.Optional;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {
    Optional<Card> findByCustomer(Customer customer);
}
