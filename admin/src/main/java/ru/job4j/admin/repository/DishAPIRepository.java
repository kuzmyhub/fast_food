package ru.job4j.admin.repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.job4j.domain.model.Dish;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DishAPIRepository {

    @Value("${api-url}")
    private String url;

    @NonNull
    private final RestTemplate client;

    public Dish save(Dish dish) {
        System.out.println(url);
        return client.postForEntity(
                url, dish, Dish.class
        ).getBody();
    }

    public Dish findById(int id) {
        return client.getForEntity(
                String.format("%s/findById?id=%s", url, id),
                Dish.class
        ).getBody();
    }

    public Dish findByName(String name) {
        return client.getForEntity(
                String.format("%s/findByName?name=%s", url, name),
                Dish.class
        ).getBody();
    }

    public boolean deleteById(int id) {
        return client.exchange(
                String.format("%s?id=%s", url, id),
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    public List<Dish> findAll() {
        return client.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Dish>>() {
                }
        ).getBody();
    }
}
