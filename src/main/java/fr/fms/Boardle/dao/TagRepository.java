package fr.fms.Boardle.dao;

import fr.fms.Boardle.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
