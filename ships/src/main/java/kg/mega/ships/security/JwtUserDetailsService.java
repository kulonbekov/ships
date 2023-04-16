package kg.mega.ships.security;

import kg.mega.ships.models.entities.user.User;
import kg.mega.ships.security.jwt.JwtUser;
import kg.mega.ships.security.jwt.JwtUserFactory;
import kg.mega.ships.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new RuntimeException("User with username " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        return jwtUser;
    }
}
