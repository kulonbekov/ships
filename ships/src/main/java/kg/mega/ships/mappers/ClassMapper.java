package kg.mega.ships.mappers;

import kg.mega.ships.models.dtos.ClassDto;
import kg.mega.ships.models.entities.Class;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClassMapper extends BaseMapper<Class, ClassDto> {

    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);
}
