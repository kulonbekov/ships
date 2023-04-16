package kg.mega.ships.models.entities;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "outcomes")
public class Outcome {

    @EmbeddedId
    OutcomeId id;
    @NotNull
    @ManyToOne
    @MapsId("shipName")
    Ship ship;
    @ManyToOne
    @MapsId("battleName")
    @NotNull
    Battle battle;
    @Column(length = 10)
    @NotNull
    String result;

}
