package ru.job4j.order.repository;

import ru.job4j.domain.model.Customer;
import ru.job4j.domain.model.Order;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface OrderRepository {
    Order add(Order order);

    boolean delete(int id);

    List<Order> findAllByCustomer(Customer customer);

}
