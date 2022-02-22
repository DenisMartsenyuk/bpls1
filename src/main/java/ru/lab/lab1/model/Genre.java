package ru.lab.lab1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bpls_genre")
@Data
public class Genre {
    @Id
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "genres")
    List<Movie> movies;
}
