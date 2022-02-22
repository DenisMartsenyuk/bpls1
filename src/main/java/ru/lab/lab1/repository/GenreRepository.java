package ru.lab.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lab.lab1.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, String> {
}
