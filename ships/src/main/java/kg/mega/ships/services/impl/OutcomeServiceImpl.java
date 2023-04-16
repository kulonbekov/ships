package kg.mega.ships.services.impl;

import kg.mega.ships.mappers.OutcomeMapper;
import kg.mega.ships.models.dtos.OutcomeDto;
import kg.mega.ships.models.entities.Outcome;
import kg.mega.ships.repository.OutcomeRep;
import kg.mega.ships.services.OutcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OutcomeServiceImpl implements OutcomeService {

    private final OutcomeRep outcomeRep;
    private OutcomeMapper outcomeMapper = OutcomeMapper.INSTANCE;

    @Override
    public OutcomeDto save(OutcomeDto outcomeDto) {
        Outcome outcome = outcomeMapper.toEntity(outcomeDto);
        outcome = outcomeRep.save(outcome);
        return outcomeMapper.toDto(outcome);
    }

    @Override
    public OutcomeDto findByName(String name) {
        return null;
    }
    @Override
    public OutcomeDto findByShipName(String name) {
        return outcomeMapper.toDto(outcomeRep.findByShipName(name));
    }

    @Override
    public List<OutcomeDto> findAll() {
        return outcomeMapper.toDtos(outcomeRep.findAll());
    }

    @Override
    public OutcomeDto update(OutcomeDto outcomeDto) {
        return null;
    }

    @Override
    @Transactional
    public void delete(String name) {
        outcomeRep.deleteByShip(name);
    }


}
