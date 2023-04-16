package kg.mega.ships.repository;

import kg.mega.ships.models.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
