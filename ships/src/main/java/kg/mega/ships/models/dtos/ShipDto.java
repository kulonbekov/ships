package kg.mega.ships.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kg.mega.ships.models.entities.Class;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShipDto {

    String name;
    Class className;
    int launched;

}
