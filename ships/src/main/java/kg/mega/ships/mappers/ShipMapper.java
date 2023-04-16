package kg.mega.ships.mappers;

import kg.mega.ships.models.dtos.ShipDto;
import kg.mega.ships.models.entities.Ship;
import org.mapstruct.Mapper;

@Mapper
public interface ShipMapper extends BaseMapper<Ship, ShipDto> {
}
