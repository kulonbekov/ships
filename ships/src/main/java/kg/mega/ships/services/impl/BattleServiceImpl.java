package kg.mega.ships.services.impl;

import kg.mega.ships.mappers.BattleMapper;
import kg.mega.ships.mappers.ClassMapper;
import kg.mega.ships.models.dtos.BattleDto;
import kg.mega.ships.models.entities.Battle;
import kg.mega.ships.models.responseDto.BattleResponseDto;
import kg.mega.ships.repository.BattleRep;
import kg.mega.ships.repository.ClassRep;
import kg.mega.ships.services.BattleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BattleServiceImpl implements BattleService {

    private final BattleRep battleRep;
    private BattleMapper battleMapper = BattleMapper.INSTANCE;
    private final ClassRep classRep;
    private ClassMapper classMapper = ClassMapper.INSTANCE;

    @Override
    public BattleResponseDto findByBattleResult(String name) {
        List<String> classList = classRep.findByBattleResult(name);
        BattleResponseDto battle_result = new BattleResponseDto();
        battle_result.setClass_names(classList);
        return battle_result;
    }

    @Override
    public BattleDto save(BattleDto battleDto) {
        Battle battle = battleMapper.toEntity(battleDto);
        battle = battleRep.save(battle);
        return battleMapper.toDto(battle);
    }

    @Override
    public BattleDto findByName(String name) {

        return battleMapper.toDto(battleRep.findById(name).orElseThrow(()
                -> new RuntimeException("Battle not found")));
    }

    @Override
    public List<BattleDto> findAll() {
        return battleMapper.toDtos(battleRep.findAll());
    }

    @Override
    public BattleDto update(BattleDto battleDto) {
        return null;
    }

    @Override
    @Transactional
    public void delete(String name) {
        battleRep.deleteByName(name);
    }


}
