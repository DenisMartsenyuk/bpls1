package ru.lab.lab1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.lab.lab1.dto.CountryRespDTO;
import ru.lab.lab1.dto.GenreRespDTO;
import ru.lab.lab1.dto.HumanRespDTO;
import ru.lab.lab1.dto.MovieRespDTO;
import ru.lab.lab1.exception.DatabaseException;
import ru.lab.lab1.model.Movie;
import ru.lab.lab1.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/movie")
    public ResponseEntity<?> getMovieInfo(@RequestParam(name = "id") Long id) throws DatabaseException {
        Movie movie = userService.getMovie(id);
        List<GenreRespDTO> genres =  movie.getGenres().stream()
                .map(x -> GenreRespDTO.builder().name(x.getName()).build())
                .collect(Collectors.toList());

        List<CountryRespDTO> countries = movie.getCountries().stream()
                .map(x -> CountryRespDTO.builder().name(x.getName()).build())
                .collect(Collectors.toList());

        List<HumanRespDTO> directors = movie.getDirectors().stream()
                .map(x -> HumanRespDTO.builder().id(x.getId()).name(x.getName()).surname(x.getSurname()).build())
                .collect(Collectors.toList());

        List<HumanRespDTO> writers = movie.getWriters().stream()
                .map(x -> HumanRespDTO.builder().id(x.getId()).name(x.getName()).surname(x.getSurname()).build())
                .collect(Collectors.toList());

        List<HumanRespDTO> actors = movie.getActors().stream()
                .map(x -> HumanRespDTO.builder().id(x.getId()).name(x.getName()).surname(x.getSurname()).build())
                .collect(Collectors.toList());


        MovieRespDTO movieRespDTO = MovieRespDTO.builder()
                .id(movie.getId())
                .name(movie.getName())
                .description(movie.getDescription())
                .year(movie.getYear())
                .runtime(movie.getRuntime())
                .genres(genres)
                .countries(countries)
                .directors(directors)
                .writers(writers)
                .actors(actors)
                .build();

        return new ResponseEntity<>(movieRespDTO, HttpStatus.OK);
    }

    @GetMapping("/humans")
    public ResponseEntity<?> getHumans() {
        List<HumanRespDTO> humanRespDTOList = userService.getHumans().stream()
                .map(x -> HumanRespDTO.builder().id(x.getId()).name(x.getName()).surname(x.getSurname()).build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(humanRespDTOList, HttpStatus.OK);
    }

    @GetMapping("/genres")
    public ResponseEntity<?> getGeneres() {
        List<GenreRespDTO> genreRespDTOList = userService.getGenres().stream()
                .map(x -> GenreRespDTO.builder().name(x.getName()).build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(genreRespDTOList, HttpStatus.OK);
    }

    @GetMapping("/countries")
    public ResponseEntity<?> getCountries() {
        List<CountryRespDTO> countryRespDTOList = userService.getCountries().stream()
                .map(x -> CountryRespDTO.builder().name(x.getName()).build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(countryRespDTOList, HttpStatus.OK);
    }


}
