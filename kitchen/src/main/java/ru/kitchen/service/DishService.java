package ru.kitchen.service;

import ru.domain.model.Order;

public interface DishService {
    void acceptOrder(Order order) throws InterruptedException;

    public void makeOrder() throws InterruptedException;
}
