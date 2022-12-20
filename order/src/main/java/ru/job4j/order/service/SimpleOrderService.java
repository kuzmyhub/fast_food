package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Customer;
import ru.job4j.domain.model.Order;
import ru.job4j.order.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleOrderService implements OrderService {

    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> findOrderById(int id) {
        return orderRepository.findById(id);
    }

    public List<Order> findAllOrdersByCustomer(Customer customer) {
        return orderRepository.findAllByCustomer(customer);
    }
}
