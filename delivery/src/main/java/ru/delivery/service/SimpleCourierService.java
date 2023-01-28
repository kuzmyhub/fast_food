package ru.delivery.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.delivery.repository.CourierRepository;
import ru.domain.model.Courier;
import ru.domain.model.Order;
import ru.domain.model.Status;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class SimpleCourierService implements CourierService {

    private CourierRepository courierRepository;

    public Order setCourier(Order order) throws InterruptedException {
        Thread.sleep(10000);
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

    public Courier save(Courier courier) {
        return courierRepository.save(courier);
    }

    public void dismissById(int id) {
        Courier courier = findById(id).orElseThrow(
                () -> new NoSuchElementException(
                        String.format(
                                "Courier id=%s not found", id
                        )
                )
        );
        courier.setDismissed(true);
        save(courier);
    }

    public void hireById(int id) {
        Courier courier = findById(id).orElseThrow(
                () -> new NoSuchElementException(
                        String.format(
                                "Courier id=%s not found", id
                        )
                )
        );
        courier.setDismissed(false);
        save(courier);
    }

    public Optional<Courier> findById(int id) {
        return courierRepository.findById(id);
    }

    public List<Courier> findAll() {
        return courierRepository.findAll();
    }
}
