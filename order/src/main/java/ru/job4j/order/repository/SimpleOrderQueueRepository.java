package ru.job4j.order.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Order;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

@Repository
public class SimpleOrderQueueRepository implements OrderQueueRepository {

    private final Queue<Order> queue = new LinkedList<>();

    public void add(Order order) {
        queue.add(order);
    }

    public Order poll() {
        return queue.poll();
    }
}
