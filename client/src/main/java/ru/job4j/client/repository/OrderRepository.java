package ru.job4j.client.repository;

import ru.job4j.domain.model.Customer;
import ru.job4j.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);

    Optional<Order> findById(int id);

    List<Order> findAllByCustomer(Customer customer);
}
