package by.savin.comprent.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity(name = "USERS")
@EqualsAndHashCode(exclude = {"role", "comments"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Long id;
    @Column(name = "USER_USERNAME", nullable = false, length = 15)
    private String username;
    @Column(name = "USER_PASSWORD", length = 80, nullable = false)
    private String password;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "ROLE_ID")
    @JsonManagedReference
    private Role role;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
