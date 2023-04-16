package kg.mega.ships.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

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
    @Column(length = 50, name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "class_name")
    Class className;
    @Column(name = "launched")
    int launched;


}
