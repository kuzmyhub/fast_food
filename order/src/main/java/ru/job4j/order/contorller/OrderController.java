package ru.job4j.order.contorller;

import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.domain.model.Customer;
import ru.job4j.domain.model.Order;
import ru.job4j.order.repository.SimpleOrderQueueRepository;
import ru.job4j.order.service.KafkaConsumerService;
import ru.job4j.order.service.KafkaProducerService;
import ru.job4j.order.service.OrderQueueService;
import ru.job4j.order.service.OrderService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private OrderService simpleOrderService;
    private KafkaProducerService simpleKafkaProducerService;
    private OrderQueueService simpleOrderQueueService;
    private KafkaConsumerService simpleKafkaConsumerService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        simpleOrderQueueService.add(order);
        simpleKafkaProducerService.sendToKitchen(order);
        simpleOrderQueueService.poll();
        /*Order order1 = simpleOrderService.createOrder(order);*/
        return new ResponseEntity<>(
                order,
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable int id) {
        Order order = simpleOrderService.findOrderById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                String.format("Order number %s not found", id
                                )
                        )
                );
        simpleKafkaProducerService.send(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAllByCustomer(
            @RequestBody Customer customer
    ) {
        return new ResponseEntity<>(
                simpleOrderService.findAllOrdersByCustomer(customer),
                HttpStatus.OK
        );
    }
}
