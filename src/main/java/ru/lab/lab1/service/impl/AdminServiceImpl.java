package ru.lab.lab1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lab.lab1.dto.SaveGenreReqDTO;
import ru.lab.lab1.model.Genre;
import ru.lab.lab1.model.Movie;
import ru.lab.lab1.repository.GenreRepository;
import ru.lab.lab1.service.AdminService;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final GenreRepository genreRepository;

    @Override
    public Movie getMovie(Long id) {
        return new Movie();
    }

    @Override
    public void saveGenre(SaveGenreReqDTO saveGenreReqDTO) {
        Genre genre = new Genre();
        genre.setName(saveGenreReqDTO.getName());
        genreRepository.save(genre);
    }
}
