package ru.job4j.admin.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.admin.repository.OrderAPIRepository;
import ru.job4j.domain.model.Order;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleOrderService implements OrderService {

    private OrderAPIRepository orderAPIRepository;

    public Optional<Order> findById(int id) {
        return orderAPIRepository.findById(id);
    }

    public List<Order> findAll() {
        return orderAPIRepository.findAll();
    }
}
