package ru.client.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.domain.model.Order;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@PropertySource("classpath:application.properties")
public class OrderAPIRepository {

    @Value("${order-api-url}")
    private String url;

    private final RestTemplate orderRestTemplate;

    public OrderAPIRepository(@Qualifier("orderRestTemplate")
                             RestTemplate orderRestTemplate) {
        this.orderRestTemplate = orderRestTemplate;
    }

    public Order save(Order order) {
        return orderRestTemplate
                .postForEntity(url, order, Order.class)
                .getBody();
    }

    public Optional<Order> findById(int id) {
        return Optional.ofNullable(orderRestTemplate.getForEntity(
                String.format("%s/%s", url, id),
                Order.class).getBody()
        );
    }

    public List<Order> findAllByCustomerId(int id) {
        List<Order> body = orderRestTemplate.exchange(
                String.format("%s?id=%s", url, id), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Order>>() {
                }
        ).getBody();
        return body == null ? Collections.emptyList() : body;
    }
}
