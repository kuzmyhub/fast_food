package ru.order.service;

import ru.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order);

    Optional<Order> findOrderById(int id);

    List<Order> findAllOrdersByCustomerId(int id);

    List<Order> findAll();
}
