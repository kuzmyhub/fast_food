package ru.job4j.order.service;

import ru.job4j.domain.model.Order;

public interface OrderQueueService {

    void add(Order order);

    Order poll();
}
