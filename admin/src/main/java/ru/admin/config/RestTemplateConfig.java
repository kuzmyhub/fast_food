package ru.admin.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    @Qualifier("dishRestTemplate")
    public RestTemplate createDishRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Qualifier("courierRestTemplate")
    public RestTemplate createCourierRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Qualifier("orderRestTemplate")
    public RestTemplate orderCourierRestTemplate() {
        return new RestTemplate();
    }
}
