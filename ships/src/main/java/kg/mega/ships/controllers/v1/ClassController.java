package kg.mega.ships.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.ships.models.dtos.BattleDto;
import kg.mega.ships.models.dtos.ClassDto;
import kg.mega.ships.services.BattleService;
import kg.mega.ships.services.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "3. Классы кораблей")
@RestController
@RequestMapping(value = "/api/v1/class")
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save (@RequestBody ClassDto classDto){
        try {
            return new ResponseEntity<>(classService.save(classDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/find/by/name")
    @ApiOperation("Поиск класса корабля по названию")
    ResponseEntity<?> findByName(@RequestParam String name) {
        try {
            return new ResponseEntity<>(classService.findByName(name), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/all")
    @ApiOperation("Вывод всех классов кораблей")
    ResponseEntity<List<ClassDto>> findAll() {
        return ResponseEntity.ok(classService.findAll());
    }

    @DeleteMapping("/delete/by/name")
    @ApiOperation("Удаления записи")
    ResponseEntity<?> delete(@RequestParam String name){
        try {
            classService.delete(name);
            return ResponseEntity.ok("database entry deleted");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
