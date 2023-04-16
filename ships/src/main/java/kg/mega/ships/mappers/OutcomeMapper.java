package kg.mega.ships.mappers;

import kg.mega.ships.models.dtos.OutcomeDto;
import kg.mega.ships.models.entities.Outcome;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OutcomeMapper extends BaseMapper<Outcome, OutcomeDto> {

    OutcomeMapper INSTANCE = Mappers.getMapper(OutcomeMapper.class);
}
