package ru.lab.lab1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bpls_role")
@Data
public class Role {
    @Id
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<IMDBUser> users;
}
