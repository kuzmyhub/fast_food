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

import java.util.List;

@Repository
@PropertySource("classpath:application.properties")
public class CourierAPIRepository {

    @Value("${courier-api-url}")
    private String url;

    private final RestTemplate deliveryRestTemplate;

    public CourierAPIRepository(@Qualifier("courierRestTemplate")
                                 RestTemplate dishRestTemplate) {
        this.deliveryRestTemplate = dishRestTemplate;
    }

    public Courier save(Courier courier) {
        return deliveryRestTemplate.postForEntity(
                url, courier, Courier.class
        ).getBody();
    }

    public boolean deleteById(int id) {
        return deliveryRestTemplate.exchange(
                String.format("%s?id=%s", url, id),
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    public List<Courier> findAll() {
        return deliveryRestTemplate.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Courier>>() {
                }
        ).getBody();
    }
}
