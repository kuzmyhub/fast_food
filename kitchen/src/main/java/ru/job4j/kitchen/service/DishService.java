package ru.job4j.kitchen.service;

import ru.job4j.domain.model.Dish;
import ru.job4j.domain.model.Order;

public interface DishService {
    void acceptOrder(Order order) throws InterruptedException;

    public void makeOrder() throws InterruptedException;
}
