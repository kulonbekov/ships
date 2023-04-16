package kg.mega.ships.repository;

import kg.mega.ships.models.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRep extends JpaRepository<Ship, String> {

    void deleteByName(String name);
}
