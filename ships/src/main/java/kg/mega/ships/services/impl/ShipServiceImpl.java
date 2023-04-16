package kg.mega.ships.services.impl;

import kg.mega.ships.mappers.ShipMapper;
import kg.mega.ships.models.dtos.ShipDto;
import kg.mega.ships.models.entities.Ship;
import kg.mega.ships.repository.ShipRep;
import kg.mega.ships.services.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipServiceImpl implements ShipService {

    private final ShipRep shipRep;
    private ShipMapper shipMapper = ShipMapper.INSTANCE;
    @Override
    public ShipDto save(ShipDto shipDto) {
        Ship ship = shipMapper.toEntity(shipDto);
        ship = shipRep.save(ship);
        return shipMapper.toDto(ship);
    }

    @Override
    public ShipDto findByName(String name) {
        return shipMapper.toDto(shipRep.findById(name).orElseThrow(()
                -> new RuntimeException("Class not found")));
    }

    @Override
    public List<ShipDto> findAll() {
        return shipMapper.toDtos(shipRep.findAll());
    }

    @Override
    public ShipDto update(ShipDto shipDto) {
        return null;
    }

    @Override
    public ShipDto delete(String name) {
        return null;
    }
}
