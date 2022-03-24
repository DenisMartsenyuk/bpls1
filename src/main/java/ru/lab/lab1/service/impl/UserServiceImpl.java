package ru.lab.lab1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lab.lab1.dto.RateMovieReqDTO;
import ru.lab.lab1.exception.DatabaseException;
import ru.lab.lab1.model.*;
import ru.lab.lab1.repository.*;
import ru.lab.lab1.service.UserService;

import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final CountryRepository countryRepository;
    private final GenreRepository genreRepository;
    private final HumanRepository humanRepository;
    private final MovieRepository movieRepository;
    private final IMDBUserRepository userRepository;
    private final RatingRepository ratingRepository;

    @Override
    public Movie getMovie(Long id) throws DatabaseException {
        return movieRepository.findMovieById(id).orElseThrow(() -> new DatabaseException("Фильм не найден"));
    }

    @Override
    public List<Human> getHumans() {
        return humanRepository.findAll();
    }

    @Override
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Override
    public void rateMovie(RateMovieReqDTO rateMovieReqDTO) throws DatabaseException {
        Movie movie = movieRepository.findMovieById(rateMovieReqDTO.getMovieId()).orElseThrow(() -> new DatabaseException("Фильм не найден"));
        IMDBUser user = userRepository.findIMDBUserByLogin(rateMovieReqDTO.getLogin()).orElseThrow(() -> new DatabaseException("Пользователь IMDb не найден"));
        setRating(movie, user, rateMovieReqDTO.getValue());
        updateAverageRatingMovie(movie);
    }

    private void setRating(Movie movie, IMDBUser user, Double value) {
        Rating rating = ratingRepository.findRatingByMovieAndUser(movie, user).orElseGet(Rating::new);
        rating.setValue(value);
        ratingRepository.save(rating);
    }

    private void updateAverageRatingMovie(Movie movie) {
        double averageRating = movie.getRatings().stream().mapToDouble(Rating::getValue).average().orElse(Double.NaN);
        movie.setAverageRating(Double.isNaN(averageRating) ? null : averageRating);
        movieRepository.save(movie);
    }

}
