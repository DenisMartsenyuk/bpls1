package ru.lab.lab1.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bpls_rating")
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private Double value;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_login", nullable = false)
    private IMDBUser user;
}
