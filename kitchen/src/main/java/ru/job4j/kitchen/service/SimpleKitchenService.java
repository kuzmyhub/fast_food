package ru.job4j.kitchen.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Kitchen;
import ru.job4j.domain.model.Order;
import ru.job4j.kitchen.repository.KitchenRepository;

@Service
@AllArgsConstructor
public class SimpleKitchenService implements KitchenService {

    private KitchenRepository kitchenRepository;
    private KafkaProducerService simpleKafkaProducerService;

    public Kitchen add(Kitchen kitchen) {
        return new Kitchen();
    }

    public void ready(Order order) {
        simpleKafkaProducerService.sendToOrder(order);
    }
}
