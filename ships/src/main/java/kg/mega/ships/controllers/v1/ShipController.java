package kg.mega.ships.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.ships.models.dtos.ShipDto;
import kg.mega.ships.services.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "2. Корабли")
@RestController
@RequestMapping(value = "/api/v1/ship")
@RequiredArgsConstructor
public class ShipController {

    private final ShipService shipService;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody ShipDto shipDto) {
        try {
            return new ResponseEntity<>(shipService.save(shipDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/find/by/name")
    @ApiOperation("Поиск корябля по названию")
    ResponseEntity<?> findByName(@RequestParam String name) {
        try {
            return new ResponseEntity<>(shipService.findByName(name), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/all")
    @ApiOperation("Вывод всех кораблей")
    ResponseEntity<List<ShipDto>> findAll() {
        return ResponseEntity.ok(shipService.findAll());
    }

    @DeleteMapping("/delete/by/name")
    @ApiOperation("Удаления записи")
    ResponseEntity<?> delete(@RequestParam String name) {
        try {
            shipService.delete(name);
            return ResponseEntity.ok("database entry deleted");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
