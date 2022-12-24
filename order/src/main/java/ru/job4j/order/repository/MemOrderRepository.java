package ru.job4j.order.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Customer;
import ru.job4j.domain.model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class MemOrderRepository implements OrderRepository {

    private final Map<Integer, Order> orders = new HashMap<>();

    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    public Order add(Order order) {
        order.setId(atomicInteger.getAndIncrement());
        orders.put(order.getId(), order);
        return order;
    }

    public boolean delete(int id) {
        Optional<Order> optionalOrder = Optional.ofNullable(orders.remove(id));
        return optionalOrder.isPresent();
    }

    public List<Order> findAllByCustomer(Customer customer) {
        return orders.values()
                .stream()
                .filter(x -> x.getCustomer().equals(customer))
                .collect(Collectors.toList());
    }
}
