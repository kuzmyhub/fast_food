package ru.job4j.service;

import ru.job4j.Dish;

public interface DishService {
    void addDish(Dish dish);

    Dish findDishById(int id);

    Dish findDishByName(String name);

    Dish deleteDish(Dish dish);
}
