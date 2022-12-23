package ru.job4j.client.repository;

import ru.job4j.domain.model.Dish;

import java.util.List;

public interface DishRepository {

    Dish findById(int id);

    List<Dish> findAll();
}
