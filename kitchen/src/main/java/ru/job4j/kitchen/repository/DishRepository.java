package ru.job4j.kitchen.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.domain.model.Kitchen;

public interface DishRepository extends CrudRepository<Kitchen, Integer> {
}
