package ru.job4j.client.service;

import ru.job4j.domain.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {

    Optional<Dish> findDishById(int id);

    public List<Dish> findAll();
}
