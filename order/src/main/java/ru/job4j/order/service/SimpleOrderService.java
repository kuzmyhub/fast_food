package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Customer;
import ru.job4j.domain.model.Order;
import ru.job4j.order.repository.MemOrderRepository;
import ru.job4j.order.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleOrderService implements OrderService {

    private OrderRepository orderRepository;
    private MemOrderRepository memOrderRepository;

    public Order createOrder(Order order) {
        /*return orderRepository.save(order);*/
        return memOrderRepository.add(order);
    }

    public Optional<Order> findOrderById(int id) {
        /*return orderRepository.findById(id);*/
        Order order = new Order();
        order.setId(1);
        order.setAmount(3000);
        return Optional.of(order);
    }

    public List<Order> findAllOrdersByCustomer(Customer customer) {
        return orderRepository.findAllByCustomer(customer);
    }
}
