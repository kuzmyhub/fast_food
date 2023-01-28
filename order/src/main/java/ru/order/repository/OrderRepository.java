package ru.order.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.domain.model.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    String FIND_ALL_BY_CUSTOMER_ID = """
            FROM Order o INNER JOIN o.customer c WHERE c.id = :fId
            """;

    @Query(FIND_ALL_BY_CUSTOMER_ID)
    List<Order> findAllByCustomerId(@Param("fId") int id);

    Order saveAndFlush(Order order);

    @NotNull
    List<Order> findAll();
}
