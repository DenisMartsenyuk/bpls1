package ru.lab.lab1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lab.lab1.dto.SaveGenreReqDTO;
import ru.lab.lab1.dto.SaveHumanReqDTO;
import ru.lab.lab1.model.Genre;
import ru.lab.lab1.model.Human;
import ru.lab.lab1.model.Movie;
import ru.lab.lab1.repository.CountryRepository;
import ru.lab.lab1.repository.GenreRepository;
import ru.lab.lab1.repository.HumanRepository;
import ru.lab.lab1.repository.MovieRepository;
import ru.lab.lab1.service.AdminService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final CountryRepository countryRepository;
    private final GenreRepository genreRepository;
    private final HumanRepository humanRepository;
    private final MovieRepository movieRepository;

    @Override
    public Movie getMovie(Long id) {
        return new Movie();
    }

    @Override
    public List<Human> getHumans() {
        return humanRepository.findAll();
    }

    @Override
    public void saveHuman(SaveHumanReqDTO saveHumanReqDTO) {
        Human human = new Human();
        human.setName(saveHumanReqDTO.getName());
        human.setSurname(saveHumanReqDTO.getSurname());
        humanRepository.save(human);
    }

    @Override
    public void saveGenre(SaveGenreReqDTO saveGenreReqDTO) {
        Genre genre = new Genre();
        genre.setName(saveGenreReqDTO.getName());
        genreRepository.save(genre);
    }
}
