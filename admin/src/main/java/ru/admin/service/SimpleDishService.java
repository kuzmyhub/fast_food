package ru.admin.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.admin.repository.DishAPIRepository;
import ru.domain.model.Dish;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleDishService implements DishService {

    private DishAPIRepository dishAPIRepository;

    public Dish addDish(Dish dish) {
        return dishAPIRepository.save(dish);
    }

    public Optional<Dish> findDishById(int id) {
        return Optional.of(dishAPIRepository.findById(id));
    }

    public Optional<Dish> findDishByName(String name) {
        return Optional.of(dishAPIRepository.findByName(name));
    }

    public boolean excludeDishById(int id) {
        return dishAPIRepository.excludeById(id);
    }

    public boolean enableDishById(int id) {
        return dishAPIRepository.enableById(id);
    }

    public List<Dish> findAll() {
        return dishAPIRepository.findAll();
    }
}
