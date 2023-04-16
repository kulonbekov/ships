package kg.mega.ships.repository;

import kg.mega.ships.models.entities.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRep extends JpaRepository<Class, String> {

    @Query(value = "SELECT DISTINCT c.class_name\n" +
            "FROM classes c\n" +
            "         INNER JOIN ships s ON c.class_name = s.class_name\n" +
            "WHERE s.name IN (\n" +
            "    SELECT o.ship\n" +
            "    FROM outcomes o\n" +
            "    WHERE o.result = 'sunk' and o.battle = :name\n" +
            ")\n" +
            "UNION\n" +
            "Select c.class_name\n" +
            "From classes c\n" +
            "INNER JOIN outcomes o ON c.class_name = o.ship\n" +
            "where o.result = 'sunk' and o.battle = :name", nativeQuery = true)
    List<String> findByBattleResult(String name);
}
