package ru.job4j.kitchen.service;

import ru.job4j.domain.model.Kitchen;
import ru.job4j.domain.model.Order;

public interface KitchenService {
    Kitchen add(Kitchen kitchen);

    void ready(Order order);
}
