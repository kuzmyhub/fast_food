package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.Card;
import ru.job4j.Customer;

import java.util.Optional;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {
    Optional<Card> findByCustomer(Customer customer);
}
