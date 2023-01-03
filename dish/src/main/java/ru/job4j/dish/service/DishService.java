package ru.job4j.dish.service;

import ru.job4j.domain.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {
    Dish addDish(Dish dish);

    Optional<Dish> findDishById(int id);

    Optional<Dish> findDishByName(String name);

    void excludeDishById(int id);

    void enableDishById(int id);

    List<Dish> findAll();
}
