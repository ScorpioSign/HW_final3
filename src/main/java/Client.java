import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "client")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "creating_profile_date_time")
    private LocalDateTime creationDateTime;
    @Column(name = "profile_modification_date_time")
    private LocalDateTime modificationDateTime;

    public Client(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.creationDateTime = LocalDateTime.now();
        this.modificationDateTime = this.creationDateTime;
    }

    @ManyToMany
    @JoinTable(name = "client_role",

            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    )
    private Set<Role> roles = new HashSet<Role>();


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", creationDateTime=" + creationDateTime +
                ", modificationDateTime=" + modificationDateTime +
                ", roleSet=" + roles +
                '}';
    }
}

