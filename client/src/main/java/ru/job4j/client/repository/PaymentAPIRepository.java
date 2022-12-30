package ru.job4j.client.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.job4j.domain.model.Payment;

@Repository
@PropertySource("classpath:application.properties")
public class PaymentAPIRepository implements PaymentRepository {

    @Value("${payment-api-url}")
    private String url;

    private final RestTemplate paymentRestTemplate;

    public PaymentAPIRepository(@Qualifier("paymentRestTemplate")
                              RestTemplate orderRestTemplate) {
        this.paymentRestTemplate = orderRestTemplate;
    }

    public Payment save(Payment payment) {
        return paymentRestTemplate
                .postForEntity(url, payment, Payment.class)
                .getBody();
    }
}
