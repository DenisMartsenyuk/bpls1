package ru.lab.lab1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bpls_movie")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "year")
    private Integer year;

    @Column(name = "runtime")
    private Integer runtime;

    @Column(name = "average_rating")
    private Double averageRating;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bpls_movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_name"))
    private Set<Genre> genres;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bpls_movie_country",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "country_name"))
    private Set<Country> countries;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bpls_movie_director",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id"))
    private Set<Human> directors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bpls_movie_writer",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "writer_id"))
    private Set<Human> writers;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bpls_movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Human> actors;

    @OneToMany(mappedBy = "movie")
    private List<Rating> ratings;
}
