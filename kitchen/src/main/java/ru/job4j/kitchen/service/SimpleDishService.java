package ru.job4j.kitchen.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Dish;
import ru.job4j.domain.model.Kitchen;
import ru.job4j.domain.model.Order;
import ru.job4j.domain.model.Status;
import ru.job4j.kitchen.repository.DishRepository;
import ru.job4j.kitchen.repository.MemDishRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleDishService implements DishService {

    private MemDishRepository memDishRepository;
    private KafkaProducerService simpleKafkaProducerService;

    public Dish add(Dish dish) {
        return new Dish();
    }

    public void ready(Order order) {
        simpleKafkaProducerService.sendToOrder(order);
    }

    public void acceptOrder(Order order) throws InterruptedException {
        List<Dish> kitchenDishes = memDishRepository.findAll();
        List<Dish> orderDishes = order.getDishes();
        Status status = new Status();
        if (!kitchenDishes.containsAll(orderDishes)) {
            status.setCondition("Отмена заказа");
            order.setStatus(status);
            simpleKafkaProducerService.sendToOrder(order);
            return;
        }
        status.setCondition("Заказ приготовлен");
        order.setStatus(status);
        makeOrder();
        simpleKafkaProducerService.sendToOrder(order);
    }

    public void makeOrder() throws InterruptedException {
        Thread.sleep(60000);
    }
}
