package ru.job4j.admin.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.admin.repository.CourierAPIRepository;
import ru.job4j.domain.model.Courier;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleCourierService implements CourierService {

    private CourierAPIRepository courierAPIRepository;

    public Courier add(Courier courier) {
        return courierAPIRepository.save(courier);
    }

    public boolean deleteById(int id) {
        return courierAPIRepository.deleteById(id);
    }

    public List<Courier> findAll() {
        return courierAPIRepository.findAll();
    }
}
