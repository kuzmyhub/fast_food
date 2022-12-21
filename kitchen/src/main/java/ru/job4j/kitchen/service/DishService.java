package ru.job4j.kitchen.service;

import ru.job4j.domain.model.Dish;
import ru.job4j.domain.model.Order;

public interface DishService {

    Dish add(Dish dish);

    void ready(Order order);

    void acceptOrder(Order order) throws InterruptedException;
}
