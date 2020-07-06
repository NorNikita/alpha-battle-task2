package ru.alpha.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alpha.task2.model.entities.Payments;

@Repository
public interface PaymentsRepo extends JpaRepository<Payments, Long> {
}
