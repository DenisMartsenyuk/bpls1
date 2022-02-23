package ru.lab.lab1.service;

import ru.lab.lab1.dto.SaveGenreReqDTO;
import ru.lab.lab1.dto.SaveHumanReqDTO;
import ru.lab.lab1.model.Human;
import ru.lab.lab1.model.Movie;

import java.util.List;

public interface AdminService {
    Movie getMovie(Long id);
    List<Human> getHumans();
    void saveHuman(SaveHumanReqDTO saveHumanReqDTO);
    void saveGenre(SaveGenreReqDTO saveGenreReqDTO);
}
