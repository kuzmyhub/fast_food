package ru.job4j.client.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.domain.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    String FIND_CUSTOMER_BY_USERNAME = """
            FROM Customer c JOIN FETCH
            c.authority WHERE c.username = :fUsername
            """;

    @Query(FIND_CUSTOMER_BY_USERNAME)
    Customer findByUsername(@Param("fUsername") String username);
}
