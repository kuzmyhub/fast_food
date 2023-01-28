package ru.delivery.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.domain.model.Courier;

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
