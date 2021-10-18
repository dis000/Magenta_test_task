package ru.magenta.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.magenta.task.entity.Distance;

@Repository
public interface DistanceRepository extends JpaRepository<Distance, Long> {
}
