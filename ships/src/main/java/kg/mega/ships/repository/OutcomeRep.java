package kg.mega.ships.repository;

import kg.mega.ships.models.entities.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OutcomeRep extends JpaRepository<Outcome, String> {

    @Query(value = "select * from outcomes where ship = :name", nativeQuery = true)
    Outcome findByShipName(String name);

    void deleteByShip(String name);
}
