package ru.admin.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.domain.model.Dish;

import java.util.List;

@Repository
@PropertySource("classpath:application.properties")
public class DishAPIRepository {

    @Value("${dish-api-url}")
    private String url;

    private final RestTemplate dishRestTemplate;

    public DishAPIRepository(@Qualifier("dishRestTemplate") RestTemplate dishRestTemplate) {
        this.dishRestTemplate = dishRestTemplate;
    }

    public Dish save(Dish dish) {
        return dishRestTemplate.postForEntity(
                url, dish, Dish.class
        ).getBody();
    }

    public Dish findById(int id) {
        return dishRestTemplate.getForEntity(
                String.format("%s/findById?id=%s", url, id),
                Dish.class
        ).getBody();
    }

    public Dish findByName(String name) {
        return dishRestTemplate.getForEntity(
                String.format("%s/findByName?name=%s", url, name),
                Dish.class
        ).getBody();
    }

    public boolean excludeById(int id) {
        return dishRestTemplate.exchange(
                String.format("%s%s?id=%s", url, "/exclude", id),
                HttpMethod.PUT,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    public boolean enableById(int id) {
        return dishRestTemplate.exchange(
                String.format("%s%s?id=%s", url, "/enable", id),
                HttpMethod.PUT,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    public List<Dish> findAll() {
        return dishRestTemplate.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Dish>>() {
                }
        ).getBody();
    }
}
