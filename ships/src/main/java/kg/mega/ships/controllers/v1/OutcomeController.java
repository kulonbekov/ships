package kg.mega.ships.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.ships.models.dtos.BattleDto;
import kg.mega.ships.models.dtos.OutcomeDto;
import kg.mega.ships.services.BattleService;
import kg.mega.ships.services.OutcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "4. Результаты")
@RestController
@RequestMapping(value = "/api/v1/outcome")
@RequiredArgsConstructor
public class OutcomeController {

    private final OutcomeService outcomeService;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save (@RequestBody OutcomeDto outcomeDto){
        try {
            return new ResponseEntity<>(outcomeService.save(outcomeDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/find/by/name")
    @ApiOperation("Поиск результата по названию")
    ResponseEntity<?> findByShipName(@RequestParam String name) {
        try {
            return new ResponseEntity<>(outcomeService.findByShipName(name), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/all")
    @ApiOperation("Вывод всех результатов")
    ResponseEntity<List<OutcomeDto>> findAll() {
        return ResponseEntity.ok(outcomeService.findAll());
    }




}
