package kg.mega.ships.models.entities;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "ships")
public class Ship {

    @Id
    @Column(length = 50)
    String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "class_name")
    ShipClass shipClass;
    @Nullable
    int launched;



}
