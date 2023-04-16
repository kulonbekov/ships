package kg.mega.ships.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "classes")
public class Class {

    @Id
    @Column(length = 50, name = "class_name")
    String className;

    @Column(length = 2, name = "type")
    String type;

    @Column(length = 20, name = "country")
    String country;

    @Column(name = "num_guns")
    int numGuns;
    @Column(name = "bore")
    double bore;
    @Column(name = "displacement")
    int displacement;

    @OneToMany(mappedBy = "className", cascade = CascadeType.REMOVE)
    List<Ship> ships;


}
