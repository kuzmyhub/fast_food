package ru.job4j.client.repository;

import org.springframework.beans.factory.annotation.Qualifier;
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
@PropertySource("classpath:application.properties")
public class DishAPIRepository implements DishRepository{

    @Value("${dish-api-url}")
    private String url;

    private final RestTemplate dishRestTemplate;

    public DishAPIRepository(@Qualifier("dishRestTemplate")
                             RestTemplate dishRestTemplate) {
        this.dishRestTemplate = dishRestTemplate;
    }

    public Optional<Dish> findById(int id) {
        return Optional.ofNullable(dishRestTemplate.getForEntity(
                String.format("%s/findById?id=%s", url, id),
                Dish.class
        ).getBody());
    }

    public List<Dish> findAll() {
        return dishRestTemplate.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Dish>>() {
                }
        ).getBody();
    }
}
