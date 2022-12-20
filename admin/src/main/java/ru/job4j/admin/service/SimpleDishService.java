package ru.job4j.admin.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.admin.repository.DishAPIRepository;
import ru.job4j.domain.model.Dish;
import ru.job4j.dish.service.DishService;

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

    public boolean deleteDishById(int id) {
        return dishAPIRepository.deleteById(id);
    }

    public List<Dish> findAll() {
        return dishAPIRepository.findAll();
    }
}
