package ru.lab.lab1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bpls_country")
@Data
public class Country {
    @Id
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "countries")
    private List<Movie> movies;
}
