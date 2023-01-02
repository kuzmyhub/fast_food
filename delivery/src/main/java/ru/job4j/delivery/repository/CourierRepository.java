package ru.job4j.delivery.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Courier;

import java.util.List;

@Repository
public interface CourierRepository extends CrudRepository<Courier, Integer> {

    String FIND_IDS = """
            SELECT id FROM Courier WHERE dismissed = false 
            """;

    @Query(FIND_IDS)
    List<Integer> findIds();

    @NotNull
    List<Courier> findAll();
}
