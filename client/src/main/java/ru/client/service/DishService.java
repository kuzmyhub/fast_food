package ru.client.service;

import ru.domain.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {

    Optional<Dish> findDishById(int id);

    List<Dish> findAll();

    List<Dish> getBasketDishes(String ids);

    int getDishAmount(List<Dish> dishes);
}
