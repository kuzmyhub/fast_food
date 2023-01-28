package ru.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.domain.model.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
