package kg.mega.ships.mappers;

import kg.mega.ships.models.dtos.BattleDto;
import kg.mega.ships.models.entities.Battle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BattleMapper extends BaseMapper<Battle, BattleDto> {
    BattleMapper INSTANCE = Mappers.getMapper(BattleMapper.class);
}
