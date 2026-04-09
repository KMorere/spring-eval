package fr.fms.Boardle.dao;

import fr.fms.Boardle.entities.Tag;
import fr.fms.Boardle.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    public Tag findByTitle(String title);
}
