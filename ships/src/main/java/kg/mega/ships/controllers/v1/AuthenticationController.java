package kg.mega.ships.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.ships.models.dtos.Security.AuthRequestDto;
import kg.mega.ships.models.dtos.Security.AuthResponseDto;
import kg.mega.ships.models.entities.user.User;
import kg.mega.ships.security.jwt.JwtTokenProvider;
import kg.mega.ships.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "5. Авторизация/Регистрация")
@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @ApiOperation("Авторизация")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findByUsername(username);

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            AuthResponseDto responseDto = new AuthResponseDto();
            responseDto.setUsername(username);
            responseDto.setToken(token);

            return ResponseEntity.ok(responseDto);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.NOT_FOUND);
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
