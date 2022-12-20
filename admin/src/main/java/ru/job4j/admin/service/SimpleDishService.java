package ru.job4j.admin.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Dish;
import ru.job4j.dish.repository.DishRepository;
import ru.job4j.dish.service.DishService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleDishService implements DishService {

    private DishRepository dishAPIRepository;

    public Dish addDish(Dish dish) {
        return dishAPIRepository.save(dish);
    }

    public Optional<Dish> findDishById(int id) {
        return dishAPIRepository.findById(id);
    }

    public Optional<Dish> findDishByName(String name) {
        return dishAPIRepository.findByName(name);
    }

    public boolean deleteDishById(int id) {
        return dishAPIRepository.deleteById(id);
    }

    public List<Dish> findAll() {
        return dishAPIRepository.findAll();
    }
}
