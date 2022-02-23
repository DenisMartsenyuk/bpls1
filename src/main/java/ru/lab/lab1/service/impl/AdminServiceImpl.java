package ru.lab.lab1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lab.lab1.dto.SaveCountryReqDTO;
import ru.lab.lab1.dto.SaveGenreReqDTO;
import ru.lab.lab1.dto.SaveHumanReqDTO;
import ru.lab.lab1.dto.SaveMovieReqDTO;
import ru.lab.lab1.model.Country;
import ru.lab.lab1.model.Genre;
import ru.lab.lab1.model.Human;
import ru.lab.lab1.model.Movie;
import ru.lab.lab1.repository.CountryRepository;
import ru.lab.lab1.repository.GenreRepository;
import ru.lab.lab1.repository.HumanRepository;
import ru.lab.lab1.repository.MovieRepository;
import ru.lab.lab1.service.AdminService;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final CountryRepository countryRepository;
    private final GenreRepository genreRepository;
    private final HumanRepository humanRepository;
    private final MovieRepository movieRepository;

    @Override
    public Movie getMovie(Long id) {
        return movieRepository.findMovieById(id);
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
    public void saveMovie(SaveMovieReqDTO saveMovieReqDTO) {
        Movie movie = new Movie();
        movie.setId(saveMovieReqDTO.getId());
        movie.setName(saveMovieReqDTO.getName());
        movie.setDescription(saveMovieReqDTO.getDescription());
        movie.setYear(saveMovieReqDTO.getYear());
        movie.setRuntime(saveMovieReqDTO.getRuntime());
        movie.setGenres(genreRepository.findGenresByNameIn(saveMovieReqDTO.getGenres()));
        movie.setCountries(countryRepository.findCountriesByNameIn(saveMovieReqDTO.getCountries()));
        movie.setDirectors(humanRepository.findHumanByIdIn(saveMovieReqDTO.getDirectors()));
        movie.setWriters(humanRepository.findHumanByIdIn(saveMovieReqDTO.getWriters()));
        movie.setActors(humanRepository.findHumanByIdIn(saveMovieReqDTO.getActors()));
        movieRepository.save(movie);
    }
}
