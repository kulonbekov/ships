package kg.mega.ships.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@IdClass(OutcomePK.class)
@Table(name = "outcomes")
public class Outcome {

    @Id
    @Column(name = "ship")
    String ship;
    @Id
    @ManyToOne
    @JoinColumn(name = "battle")
    Battle battle;
    @Column(length = 10, name = "result")
    String result;

}
