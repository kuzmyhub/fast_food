package ru.job4j.delivery.service;

import ru.job4j.domain.model.Courier;
import ru.job4j.domain.model.Order;

public interface CourierService {

    Order setCourier(Order order);

    Courier chooseCourier();

    Order deliverOrder(Order order) throws InterruptedException;
}
