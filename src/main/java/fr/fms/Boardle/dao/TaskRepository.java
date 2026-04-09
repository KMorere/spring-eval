package fr.fms.Boardle.dao;

import fr.fms.Boardle.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findByTitleContains(String keyword);
    public List<Task> findByTagId(Long tagId);
}
