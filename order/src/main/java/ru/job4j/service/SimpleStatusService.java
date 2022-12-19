package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.Status;
import ru.job4j.repository.StatusRepository;

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
