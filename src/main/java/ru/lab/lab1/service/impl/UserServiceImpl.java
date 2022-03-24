package ru.lab.lab1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lab.lab1.exception.DatabaseException;
import ru.lab.lab1.model.Country;
import ru.lab.lab1.model.Genre;
import ru.lab.lab1.model.Human;
import ru.lab.lab1.model.Movie;
import ru.lab.lab1.repository.CountryRepository;
import ru.lab.lab1.repository.GenreRepository;
import ru.lab.lab1.repository.HumanRepository;
import ru.lab.lab1.repository.MovieRepository;
import ru.lab.lab1.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final CountryRepository countryRepository;
    private final GenreRepository genreRepository;
    private final HumanRepository humanRepository;
    private final MovieRepository movieRepository;

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

}
