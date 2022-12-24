package ru.job4j.client.repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.job4j.domain.model.Dish;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class DishAPIRepository implements DishRepository{

    @Value("${dish-api-url}")
    private String url;

    @NonNull
    private final RestTemplate client;

    public Optional<Dish> findById(int id) {
        return Optional.ofNullable(client.getForEntity(
                String.format("%s/findById?id=%s", url, id),
                Dish.class
        ).getBody());
    }

    public List<Dish> findAll() {
        return client.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Dish>>() {
                }
        ).getBody();
    }
}
