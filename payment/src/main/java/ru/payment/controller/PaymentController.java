package ru.payment.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.domain.model.Payment;
import ru.payment.service.KafkaProducerService;
import ru.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {

    private PaymentService simplePaymentService;
    private KafkaProducerService simpleKafkaProducerService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        simplePaymentService.save(payment);
        simpleKafkaProducerService.sendPaymentStatusNotification(payment);
        return new ResponseEntity<>(
                payment, HttpStatus.OK
        );
    }
}
