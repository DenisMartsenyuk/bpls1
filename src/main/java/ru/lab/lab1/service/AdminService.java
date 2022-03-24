package ru.lab.lab1.service;

import ru.lab.lab1.dto.SaveCountryReqDTO;
import ru.lab.lab1.dto.SaveGenreReqDTO;
import ru.lab.lab1.dto.SaveHumanReqDTO;
import ru.lab.lab1.dto.SaveMovieReqDTO;
import ru.lab.lab1.exception.DatabaseException;

public interface AdminService {
    void saveHuman(SaveHumanReqDTO saveHumanReqDTO);
    void saveGenre(SaveGenreReqDTO saveGenreReqDTO);
    void saveCountry(SaveCountryReqDTO saveCountryReqDTO);
    void saveMovie(SaveMovieReqDTO saveMovieReqDTO) throws DatabaseException;
}
