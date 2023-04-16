package kg.mega.ships.models.entities;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "classes")
public class ShipClass {

    @Id
    @Column(length = 50)
    @NotNull
    String className;
    @NotNull
    @Column(length = 2)
    String type;
    @NotNull
    @Column(length = 20)
    String country;
    @Nullable
    int numGuns;
    @Nullable
    double bore;
    @Nullable
    int displacement;



}
