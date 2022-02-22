package ru.lab.lab1.service;

import ru.lab.lab1.dto.SaveGenreReqDTO;
import ru.lab.lab1.model.Movie;

public interface AdminService {
    Movie getMovie(Long id);
    void saveGenre(SaveGenreReqDTO saveGenreReqDTO);
}
