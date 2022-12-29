package ru.job4j.kitchen.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Dish;
import ru.job4j.domain.model.Order;
import ru.job4j.domain.model.Status;
import ru.job4j.kitchen.repository.DishRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleDishService implements DishService {

    private DishRepository simpleDishRepository;
    private KafkaProducerService simpleKafkaProducerService;

    public void acceptOrder(Order order) throws InterruptedException {
        List<Dish> kitchenDishes = simpleDishRepository.findAll();
        List<Dish> orderDishes = order.getDishes();
        Status status;
        if (!kitchenDishes.containsAll(orderDishes)) {
            status = Status.CANCEL;
            order.setStatus(status);
            simpleKafkaProducerService.sendToOrder(order);
            return;
        }
        status = Status.COOKED;
        order.setStatus(status);
        makeOrder();
        simpleKafkaProducerService.sendToOrder(order);
    }

    public void makeOrder() throws InterruptedException {
        Thread.sleep(5000);
    }
}
