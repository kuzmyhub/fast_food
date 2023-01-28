package ru.client.repository;

import ru.domain.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository {

    Optional<Dish> findById(int id);

    List<Dish> findAll();
}
