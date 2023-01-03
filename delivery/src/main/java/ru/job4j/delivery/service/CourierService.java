package ru.job4j.delivery.service;

import ru.job4j.domain.model.Courier;
import ru.job4j.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface CourierService {

    Order setCourier(Order order) throws InterruptedException;

    Courier chooseCourier();

    Order deliverOrder(Order order) throws InterruptedException;

    Courier save(Courier courier);

    void dismissById(int id);

    void hireById(int id);

    Optional<Courier> findById(int id);

    List<Courier> findAll();

}
