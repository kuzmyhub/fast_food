package ru.job4j.delivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Courier;

@Repository
public interface CourierRepository extends CrudRepository<Courier, Integer> {
}
