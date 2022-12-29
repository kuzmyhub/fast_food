package ru.job4j.order.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.domain.model.Customer;
import ru.job4j.domain.model.Order;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findAllByCustomer(Customer customer);

}
