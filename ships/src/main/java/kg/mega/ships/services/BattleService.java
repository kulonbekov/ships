package kg.mega.ships.services;

import kg.mega.ships.models.dtos.BattleDto;
import kg.mega.ships.models.responseDto.BattleResponseDto;

public interface BattleService extends BaseService<BattleDto> {

    BattleResponseDto findByBattleResult(String name);
}
