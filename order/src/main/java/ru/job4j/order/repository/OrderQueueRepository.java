package ru.job4j.order.repository;

import ru.job4j.domain.model.Order;

public interface OrderQueueRepository {

    void add(Order order);

    Order poll();
}
