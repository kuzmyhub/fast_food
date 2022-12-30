package ru.job4j.client.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.client.repository.DishRepository;
import ru.job4j.domain.model.Dish;

import java.util.*;

@Service
@AllArgsConstructor
public class SimpleDishService implements DishService {

    private DishRepository dishAPIRepository;

    public Optional<Dish> findDishById(int id) {
        return dishAPIRepository.findById(id);
    }

    public List<Dish> findAll() {
        return dishAPIRepository.findAll();
    }

    public List<Dish> getBasketDishes(String ids) {
        List<Dish> dishes = new ArrayList<>();
        String[] dishesId = ids.split("\\.");
        for (String s : dishesId) {
            int id = Integer.parseInt(s);
            Optional<Dish> optionalDish = findDishById(id);
            if (optionalDish.isEmpty()) {
                throw new NoSuchElementException(
                        String.format("Dish number %s not found", id)
                );
            }
            dishes.add(optionalDish.get());
        }
        return dishes;
    }

    public int getDishAmount(List<Dish> dishes) {
        int amount = 0;
        for (Dish d : dishes) {
            amount = amount + d.getCost();
        }
        return amount;
    }
}
