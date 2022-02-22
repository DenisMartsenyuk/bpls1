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
    String name;

    @ManyToMany(mappedBy = "countries")
    List<Movie> movies;
}
