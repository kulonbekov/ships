package kg.mega.ships.mappers;

import kg.mega.ships.models.dtos.BattleDto;
import kg.mega.ships.models.entities.Battle;
import org.mapstruct.Mapper;

@Mapper
public interface BattleMapper extends BaseMapper<Battle, BattleDto> {
}
