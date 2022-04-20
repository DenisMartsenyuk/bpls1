package ru.lab.lab1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bpls_imdb_user")
@Data
public class IMDBUser {
    @Id
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_name", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Rating> ratings;
}
