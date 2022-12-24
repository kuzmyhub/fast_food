package ru.job4j.client.repository;

import ru.job4j.domain.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository {

    Optional<Dish> findById(int id);

    List<Dish> findAll();
}
