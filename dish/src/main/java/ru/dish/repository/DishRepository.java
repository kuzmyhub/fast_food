package ru.dish.repository;

import org.springframework.data.repository.CrudRepository;
import ru.domain.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends CrudRepository<Dish, Integer> {
    Optional<Dish> findByName(String name);

    List<Dish> findAll();
}
