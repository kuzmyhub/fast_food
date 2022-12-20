package ru.job4j.dish.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.domain.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends CrudRepository<Dish, Integer> {
    Optional<Dish> findByName(String name);

    List<Dish> findAll();

    boolean deleteById(int id);
}
