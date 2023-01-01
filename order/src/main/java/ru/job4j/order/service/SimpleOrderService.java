package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Customer;
import ru.job4j.domain.model.Order;
import ru.job4j.domain.model.Status;
import ru.job4j.order.repository.CustomerRepository;
import ru.job4j.order.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleOrderService implements OrderService {

    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        if (order.getStatus() == null) {
            order.setStatus(Status.CREATED);
        }
        return orderRepository.save(order);
    }

    public Optional<Order> findOrderById(int id) {
        return orderRepository.findById(id);
    }

    public List<Order> findAllOrdersByCustomerId(int id) {
        return orderRepository.findAllByCustomerId(id);
    }
}
