package ru.delivery.service;

import ru.domain.model.Courier;
import ru.domain.model.Order;

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
