package kg.mega.ships.models.entities.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import kg.mega.ships.models.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "username", unique = true)
    @NotNull()
    String username;
    @Column(name = "password")
    @NotNull()
    String password;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    List<Role> roles;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    Status status;
    Date updated;


    @PrePersist
    protected void onCreate() {
        updated=new Date();
        status = Status.ACTIVE;
    }
    @PreUpdate
    protected void onUpdate(){
        updated = new Date();
    }
}

