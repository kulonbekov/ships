package kg.mega.ships.services;

import com.fasterxml.jackson.databind.ser.Serializers;
import kg.mega.ships.models.dtos.OutcomeDto;

public interface OutcomeService extends BaseService<OutcomeDto> {

    OutcomeDto findByShipName(String name);
}
