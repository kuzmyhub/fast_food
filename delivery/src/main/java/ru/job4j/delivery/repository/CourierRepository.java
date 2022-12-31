package ru.job4j.delivery.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Courier;

import java.util.List;

@Repository
public interface CourierRepository extends CrudRepository<Courier, Integer> {

    String FIND_IDS = """
            SELECT id FROM Courier
            """;

    @Query(FIND_IDS)
    List<Integer> findIds();
}
