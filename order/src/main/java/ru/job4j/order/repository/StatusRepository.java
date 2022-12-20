package ru.job4j.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Status;

@Repository
public interface StatusRepository extends CrudRepository<Status, Integer> {
}
