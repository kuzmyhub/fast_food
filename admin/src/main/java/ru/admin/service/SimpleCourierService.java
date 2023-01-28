package ru.admin.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.admin.repository.CourierAPIRepository;
import ru.domain.model.Courier;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleCourierService implements CourierService {

    private CourierAPIRepository courierAPIRepository;

    public Courier add(Courier courier) {
        return courierAPIRepository.save(courier);
    }

    public boolean dismissById(int id) {
        return courierAPIRepository.dismissById(id);
    }

    public boolean hireById(int id) {
        return courierAPIRepository.hireById(id);
    }

    public List<Courier> findAll() {
        return courierAPIRepository.findAll();
    }
}
