package ru.alpha.task2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.alpha.task2.model.Payments;

@Repository
public interface PaymentsRepo extends CrudRepository<Payments, Long> {
}
