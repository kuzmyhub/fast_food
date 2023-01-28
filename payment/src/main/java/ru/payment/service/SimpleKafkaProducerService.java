package ru.payment.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.domain.model.Payment;

@Service
@AllArgsConstructor
public class SimpleKafkaProducerService implements KafkaProducerService {

    private KafkaTemplate<Integer, Payment> template;

    public void sendPaymentStatusNotification(Payment payment) {
        template.send("paymentStatusNotification", payment);
        System.out.println("Уведомление отправлено " + payment.getOrder().getAddress());
    }
}
