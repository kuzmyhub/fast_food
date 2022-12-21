package ru.job4j.kitchen.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Dish;
import ru.job4j.domain.model.Order;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MemDishRepository {

    private final Map<Integer, Dish> dishes = new HashMap<>();

    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    public Dish add(Dish dish) {
        dish.setId(atomicInteger.getAndIncrement());
        dishes.put(dish.getId(), dish);
        return dish;
    }

    public boolean delete(int id) {
        Optional<Dish> optionalOrder = Optional.ofNullable(dishes.remove(id));
        return optionalOrder.isPresent();
    }

    public List<Dish> findAll() {
        return new ArrayList<>(dishes.values());
    }
}
