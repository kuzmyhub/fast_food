package ru.job4j.client.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.client.repository.DishAPIRepository;
import ru.job4j.domain.model.Dish;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleDishService implements DishService {

    private DishAPIRepository dishAPIRepository;

    public Optional<Dish> findDishById(int id) {
        return dishAPIRepository.findById(id);
    }

    public List<Dish> findAll() {
        return dishAPIRepository.findAll();
    }
}
