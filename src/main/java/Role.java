import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

//@ToString
@EqualsAndHashCode(of = "roleId")

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "client_role",

            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<Client> clientSet = new HashSet<Client>();


    @Override
    public String toString() {
        return "Role{" +
                "Id=" + roleId + " "
                + roleName + '\'' +
                '}';
    }
}
