package ru.job4j.admin.service;

import ru.job4j.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<Order> findById(int id);

    List<Order> findAll();
}
