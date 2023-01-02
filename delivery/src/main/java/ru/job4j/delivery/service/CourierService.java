package ru.job4j.delivery.service;

import ru.job4j.domain.model.Courier;
import ru.job4j.domain.model.Order;

import java.util.List;

public interface CourierService {

    Order setCourier(Order order);

    Courier chooseCourier();

    Order deliverOrder(Order order) throws InterruptedException;

    Courier save(Courier courier);

    void deleteById(int id);

    List<Courier> findAll();

}
