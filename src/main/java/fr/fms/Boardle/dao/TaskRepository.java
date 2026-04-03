package fr.fms.Boardle.dao;

import fr.fms.Boardle.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
