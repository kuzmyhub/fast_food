package ru.job4j.kitchen.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import ru.job4j.domain.model.Order;

public interface KafkaConsumerService {

    void onApiCall(ConsumerRecord<Integer, Order> input);
}
