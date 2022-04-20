package ru.lab.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lab.lab1.model.IMDBUser;
import ru.lab.lab1.model.Movie;
import ru.lab.lab1.model.Rating;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    Optional<Rating> findRatingByMovieAndUser(Movie movie, IMDBUser user);
    List<Rating> findRatingsByDateAfter(Date date);
}
