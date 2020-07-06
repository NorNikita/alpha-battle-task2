package ru.alpha.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alpha.task2.model.entities.Payments;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentsRepo extends JpaRepository<Payments, Long> {

    Optional<List<Payments>> findAllByUserId(String userId);
}
