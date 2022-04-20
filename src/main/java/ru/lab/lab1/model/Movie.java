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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (!id.equals(movie.id)) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        if (description != null ? !description.equals(movie.description) : movie.description != null) return false;
        if (year != null ? !year.equals(movie.year) : movie.year != null) return false;
        if (runtime != null ? !runtime.equals(movie.runtime) : movie.runtime != null) return false;
        if (averageRating != null ? !averageRating.equals(movie.averageRating) : movie.averageRating != null)
            return false;
        if (genres != null ? !genres.equals(movie.genres) : movie.genres != null) return false;
        if (countries != null ? !countries.equals(movie.countries) : movie.countries != null) return false;
        if (directors != null ? !directors.equals(movie.directors) : movie.directors != null) return false;
        if (writers != null ? !writers.equals(movie.writers) : movie.writers != null) return false;
        if (actors != null ? !actors.equals(movie.actors) : movie.actors != null) return false;
        return ratings != null ? ratings.equals(movie.ratings) : movie.ratings == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (runtime != null ? runtime.hashCode() : 0);
        result = 31 * result + (averageRating != null ? averageRating.hashCode() : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        result = 31 * result + (countries != null ? countries.hashCode() : 0);
        result = 31 * result + (directors != null ? directors.hashCode() : 0);
        result = 31 * result + (writers != null ? writers.hashCode() : 0);
        result = 31 * result + (actors != null ? actors.hashCode() : 0);
        result = 31 * result + (ratings != null ? ratings.hashCode() : 0);
        return result;
    }
}
