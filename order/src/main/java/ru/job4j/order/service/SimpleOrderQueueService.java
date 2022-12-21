package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Order;
import ru.job4j.order.repository.OrderQueueRepository;

@Service
@AllArgsConstructor
public class SimpleOrderQueueService implements OrderQueueService {

    private OrderQueueRepository simpleOrderQueueRepository;

    public void add(Order order) {
        simpleOrderQueueRepository.add(order);
    }

    public Order poll() {
        return simpleOrderQueueRepository.poll();
    }
}
