package ru.job4j.order.service;

import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Status;
import ru.job4j.order.repository.StatusRepository;

import java.util.Optional;

@Service
public class SimpleStatusService implements StatusService {

    private StatusRepository statusRepository;

    public Optional<Status> checkStatus(int orderId) {
        return statusRepository.findById(orderId);
    }

    public Status updateStatus(Status status) {
        return statusRepository.save(status);
    }
}
