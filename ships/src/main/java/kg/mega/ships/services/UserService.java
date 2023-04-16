package kg.mega.ships.services;


import kg.mega.ships.models.entities.user.User;

import java.util.List;

public interface UserService {

    User register(User user);

    User findByUsername(String username);
}
