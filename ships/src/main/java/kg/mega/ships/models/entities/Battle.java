package kg.mega.ships.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "battles")
public class Battle {

    @Id
    @Column(length = 20)
    String name;
    @JsonFormat(pattern = "yyyy.MM.dd")
    Date date;
    @OneToMany(mappedBy = "battle", cascade = CascadeType.REMOVE)
    List<Outcome> outcomes;
}
