package kg.mega.ships.repository;

import kg.mega.ships.models.entities.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRep extends JpaRepository<Class, String> {
}
