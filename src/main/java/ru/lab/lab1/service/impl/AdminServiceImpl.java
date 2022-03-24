package ru.lab.lab1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lab.lab1.dto.SaveCountryReqDTO;
import ru.lab.lab1.dto.SaveGenreReqDTO;
import ru.lab.lab1.dto.SaveHumanReqDTO;
import ru.lab.lab1.dto.SaveMovieReqDTO;
import ru.lab.lab1.exception.DatabaseException;
import ru.lab.lab1.model.Country;
import ru.lab.lab1.model.Genre;
import ru.lab.lab1.model.Human;
import ru.lab.lab1.model.Movie;
import ru.lab.lab1.repository.CountryRepository;
import ru.lab.lab1.repository.GenreRepository;
import ru.lab.lab1.repository.HumanRepository;
import ru.lab.lab1.repository.MovieRepository;
import ru.lab.lab1.service.AdminService;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final CountryRepository countryRepository;
    private final GenreRepository genreRepository;
    private final HumanRepository humanRepository;
    private final MovieRepository movieRepository;

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

    @Override
    public void saveCountry(SaveCountryReqDTO saveCountryReqDTO) {
        Country country = new Country();
        country.setName(saveCountryReqDTO.getName());
        countryRepository.save(country);
    }

    @Override
    public void saveMovie(SaveMovieReqDTO saveMovieReqDTO) throws DatabaseException {
        Set<Genre> genres = genreRepository.findGenresByNameIn(saveMovieReqDTO.getGenres());
        if (genres.size() != saveMovieReqDTO.getGenres().size()) {
            throw new DatabaseException("Найдены не все жанры");
        }
        Set<Country> countries = countryRepository.findCountriesByNameIn(saveMovieReqDTO.getCountries());
        if (countries.size() != saveMovieReqDTO.getCountries().size()) {
            throw new DatabaseException("Найдены не все страны");
        }
        Set<Human> directors = humanRepository.findHumanByIdIn(saveMovieReqDTO.getDirectors());
        if (directors.size() != saveMovieReqDTO.getDirectors().size()) {
            throw new DatabaseException("Найдены не все режиссеры");
        }
        Set<Human> writers = humanRepository.findHumanByIdIn(saveMovieReqDTO.getWriters());
        if (writers.size() != saveMovieReqDTO.getWriters().size()) {
            throw new DatabaseException("Найдены не все сценаристы");
        }
        Set<Human> actors = humanRepository.findHumanByIdIn(saveMovieReqDTO.getActors());
        if (actors.size() != saveMovieReqDTO.getActors().size()) {
            throw new DatabaseException("Найдены не все актеры");
        }

        Movie movie = new Movie();
        movie.setId(saveMovieReqDTO.getId());
        movie.setName(saveMovieReqDTO.getName());
        movie.setDescription(saveMovieReqDTO.getDescription());
        movie.setYear(saveMovieReqDTO.getYear());
        movie.setRuntime(saveMovieReqDTO.getRuntime());
        movie.setGenres(genres);
        movie.setCountries(countries);
        movie.setDirectors(directors);
        movie.setWriters(writers);
        movie.setActors(actors);
        movieRepository.save(movie);
    }
}
