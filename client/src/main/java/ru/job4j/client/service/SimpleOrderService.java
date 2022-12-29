package ru.job4j.client.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.client.repository.OrderRepository;
import ru.job4j.domain.model.Customer;
import ru.job4j.domain.model.Order;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleOrderService implements OrderService {

    private OrderRepository orderAPIRepository;

    public Order createOrder(Order order) {
        return orderAPIRepository.save(order);
    }

    public Optional<Order> findOrderById(int id) {
        return orderAPIRepository.findById(id);
    }

    public List<Order> findAllOrdersByCustomer(Customer customer) {
        return orderAPIRepository.findAllByCustomer(customer);
    }
}
