package kg.mega.ships.services.impl;

import kg.mega.ships.models.entities.user.User;
import kg.mega.ships.repository.UserRep;
import kg.mega.ships.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRep userRep;


    @Override
    public User register(User user) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return userRep.findByUsername(username);
    }
}
