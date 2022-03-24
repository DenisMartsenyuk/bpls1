package ru.lab.lab1.service;

import ru.lab.lab1.exception.DatabaseException;
import ru.lab.lab1.model.Country;
import ru.lab.lab1.model.Genre;
import ru.lab.lab1.model.Human;
import ru.lab.lab1.model.Movie;

import java.util.List;

public interface UserService {
    Movie getMovie(Long id) throws DatabaseException;
    List<Human> getHumans();
    List<Genre> getGenres();
    List<Country> getCountries();
}
