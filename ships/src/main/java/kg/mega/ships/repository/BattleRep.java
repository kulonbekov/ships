package kg.mega.ships.repository;

import kg.mega.ships.models.entities.Battle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleRep extends JpaRepository<Battle, String> {
}
