package ru.admin.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.admin.repository.OrderAPIRepository;
import ru.domain.model.Order;

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
