package ru.lab.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lab.lab1.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
