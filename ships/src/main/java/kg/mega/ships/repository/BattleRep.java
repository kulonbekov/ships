package kg.mega.ships.repository;

import kg.mega.ships.models.entities.Battle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleRep extends JpaRepository<Battle, String> {

    //@Query(value = "DELETE FROM battles WHERE name = :name", nativeQuery = true)
    void deleteByName(String name);
}
