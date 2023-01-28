package ru.admin.service;

import ru.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<Order> findById(int id);

    List<Order> findAll();
}
