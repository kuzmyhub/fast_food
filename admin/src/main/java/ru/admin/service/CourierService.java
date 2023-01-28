package ru.admin.service;

import ru.domain.model.Courier;

import java.util.List;

public interface CourierService {

    Courier add(Courier courier);

    boolean dismissById(int id);

    boolean hireById(int id);

    List<Courier> findAll();
}
