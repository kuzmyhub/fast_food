package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.Status;

@Repository
public interface StatusRepository extends CrudRepository<Status, Integer> {
}
