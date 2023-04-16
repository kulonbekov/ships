package kg.mega.ships.mappers;

import kg.mega.ships.models.dtos.ClassDto;
import kg.mega.ships.models.entities.Class;
import org.mapstruct.Mapper;

@Mapper
public interface ClassMapper extends BaseMapper<Class, ClassDto> {
}
