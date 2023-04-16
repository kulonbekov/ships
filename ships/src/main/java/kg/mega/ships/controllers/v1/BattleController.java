package kg.mega.ships.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.ships.models.dtos.BattleDto;
import kg.mega.ships.services.BattleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "1. Битвы")
@RestController
@RequestMapping(value = "/api/v1/battle")
@RequiredArgsConstructor
public class BattleController {

    private final BattleService battleService;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody BattleDto battleDto) {
        try {
            return new ResponseEntity<>(battleService.save(battleDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/find/by/name")
    @ApiOperation("Поиск битвы по названию")
    ResponseEntity<?> findByName(@RequestParam String name) {
        try {
            return new ResponseEntity<>(battleService.findByName(name), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/all")
    @ApiOperation("Вывод всех битв")
    ResponseEntity<List<BattleDto>> findAll() {
        return ResponseEntity.ok(battleService.findAll());
    }

    @GetMapping("/find/by/battle/result")
    @ApiOperation("Поиск классы кораблей, в которых хотя бы один корабль был потоплен в сражении")
    ResponseEntity<?> findByBattleResult(@RequestParam String name) {
        try {
            return new ResponseEntity<>(battleService.findByBattleResult(name), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/by/name")
    @ApiOperation("Удаления записи")
    ResponseEntity<?> delete(@RequestParam String name) {
        try {
            battleService.delete(name);
            return ResponseEntity.ok("database entry deleted");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
