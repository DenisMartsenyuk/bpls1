package ru.lab.lab1.service;

import ru.lab.lab1.dto.SaveCountryReqDTO;
import ru.lab.lab1.dto.SaveGenreReqDTO;
import ru.lab.lab1.dto.SaveHumanReqDTO;
import ru.lab.lab1.dto.SaveMovieReqDTO;
import ru.lab.lab1.exception.DatabaseException;
import ru.lab.lab1.model.Country;
import ru.lab.lab1.model.Genre;
import ru.lab.lab1.model.Human;
import ru.lab.lab1.model.Movie;

import java.util.List;

public interface AdminService {
    Movie getMovie(Long id) throws DatabaseException;
    List<Human> getHumans();
    List<Genre> getGenres();
    List<Country> getCountries();
    void saveHuman(SaveHumanReqDTO saveHumanReqDTO);
    void saveGenre(SaveGenreReqDTO saveGenreReqDTO);
    void saveCountry(SaveCountryReqDTO saveCountryReqDTO);
    void saveMovie(SaveMovieReqDTO saveMovieReqDTO) throws DatabaseException;
}
