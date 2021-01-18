package by.savin.comprent.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "ROLES")

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID", nullable = false)
    private Long id;
    @Column(name = "ROLE_NAME", nullable = false)
    private String name;
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    @JsonBackReference
    private Collection<User> users;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
