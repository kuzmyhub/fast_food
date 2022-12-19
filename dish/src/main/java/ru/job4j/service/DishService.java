package ru.job4j.service;

import ru.job4j.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {
    Dish addDish(Dish dish);

    Optional<Dish> findDishById(int id);

    Optional<Dish> findDishByName(String name);

    boolean deleteDishById(int id);

    List<Dish> findAll();
}
