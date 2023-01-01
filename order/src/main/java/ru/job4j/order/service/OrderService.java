package ru.job4j.order.service;

import ru.job4j.domain.model.Customer;
import ru.job4j.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order);

    Optional<Order> findOrderById(int id);

    List<Order> findAllOrdersByCustomerId(int id);
}
