package ru.job4j.admin.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.job4j.domain.model.Courier;
import ru.job4j.domain.model.Order;

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

    public Optional<Order> findById(int id) {
        return Optional.ofNullable(orderRestTemplate.getForEntity(
                String.format("%s/%s", url, id),
                Order.class).getBody()
        );
    }

    public List<Order> findAll() {
        List<Order> body = orderRestTemplate.exchange(
                String.format("%s%s", url, "/all"), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Order>>() {
                }
        ).getBody();
        return body == null ? Collections.emptyList() : body;
    }
}
