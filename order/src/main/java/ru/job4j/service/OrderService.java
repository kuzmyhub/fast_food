package ru.job4j.service;

import ru.job4j.Customer;
import ru.job4j.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order);

    Optional<Order> findOrderById(int id);

    List<Order> findAllOrdersByCustomer(Customer customer);
}
