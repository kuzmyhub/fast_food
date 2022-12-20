package ru.job4j.order.service;

import ru.job4j.domain.model.Status;

import java.util.Optional;

public interface StatusService {
    Optional<Status> checkStatus(int orderId);

    Status updateStatus(Status status);
}
