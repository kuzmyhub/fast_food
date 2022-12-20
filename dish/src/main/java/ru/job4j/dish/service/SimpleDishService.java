package ru.job4j.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.dish.repository.DishRepository;
import ru.job4j.domain.model.Dish;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SimpleDishService implements DishService {

    private DishRepository dishRepository;

    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public Optional<Dish> findDishById(int id) {
        return dishRepository.findById(id);
    }

    public Optional<Dish> findDishByName(String name) {
        return dishRepository.findByName(name);
    }

    public boolean deleteDishById(int id) {
        return dishRepository.deleteById(id);
    }

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }
}
