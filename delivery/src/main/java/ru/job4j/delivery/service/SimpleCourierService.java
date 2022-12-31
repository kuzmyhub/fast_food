package ru.job4j.delivery.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.delivery.repository.CourierRepository;
import ru.job4j.domain.model.Courier;
import ru.job4j.domain.model.Order;
import ru.job4j.domain.model.Status;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
@AllArgsConstructor
public class SimpleCourierService implements CourierService {

    private CourierRepository courierRepository;

    public Order setCourier(Order order) {
        Courier courier = chooseCourier();
        order.setCourier(courier);
        order.setStatus(Status.DELIVERED);
        return order;
    }

    public Courier chooseCourier() {
        Random random = new Random();
        List<Integer> courierIds = courierRepository.findIds();
        int courierId = courierIds.get(random.nextInt(courierIds.size()));
        return courierRepository.findById(courierId)
                .orElseThrow(
                        () -> new NoSuchElementException(
                                String.format(
                                        "Courier id=%s not found", courierId
                                )
                        )
                );
    }

    public Order deliverOrder(Order order) throws InterruptedException {
        Thread.sleep(10000);
        order.setStatus(Status.DELIVERY);
        return order;
    }
}
