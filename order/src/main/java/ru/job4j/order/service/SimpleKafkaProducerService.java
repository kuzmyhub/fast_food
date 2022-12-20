package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Order;

@Service
@AllArgsConstructor
public class SimpleKafkaProducerService implements KafkaProducerService {

    private KafkaTemplate<Integer, Order> template;

    public void send(Order order) {
        System.out.println("пре" + order);
        template.send("notification", order);
        System.out.println("пост" + order);
    }
}
