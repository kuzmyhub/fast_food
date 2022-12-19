package ru.job4j.service;

import ru.job4j.Status;

import java.util.Optional;

public interface StatusService {
    Optional<Status> checkStatus(int orderId);

    Status updateStatus(Status status);
}
