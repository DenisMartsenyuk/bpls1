package ru.lab.lab1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lab.lab1.dto.*;
import ru.lab.lab1.exception.DatabaseException;
import ru.lab.lab1.model.Movie;
import ru.lab.lab1.service.AdminService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/movie")
    public ResponseEntity<?> getMovieInfo(@RequestParam(name = "id") Long id) throws DatabaseException {
        Movie movie = adminService.getMovie(id);
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
        List<HumanRespDTO> humanRespDTOList = adminService.getHumans().stream()
                .map(x -> HumanRespDTO.builder().id(x.getId()).name(x.getName()).surname(x.getSurname()).build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(humanRespDTOList, HttpStatus.OK);
    }

    @GetMapping("/genres")
    public ResponseEntity<?> getGeneres() {
        List<GenreRespDTO> genreRespDTOList = adminService.getGenres().stream()
                .map(x -> GenreRespDTO.builder().name(x.getName()).build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(genreRespDTOList, HttpStatus.OK);
    }

    @GetMapping("/countries")
    public ResponseEntity<?> getCountries() {
        List<CountryRespDTO> countryRespDTOList = adminService.getCountries().stream()
                .map(x -> CountryRespDTO.builder().name(x.getName()).build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(countryRespDTOList, HttpStatus.OK);
    }

    @PostMapping("/save-human")
    public ResponseEntity<?> saveHuman(@RequestBody SaveHumanReqDTO saveHumanReqDTO) {
        adminService.saveHuman(saveHumanReqDTO);
        return new ResponseEntity<>(MessageRespDTO.builder().message("Человек сохранен").build(), HttpStatus.OK);
    }

    @PostMapping("/save-genre")
    public ResponseEntity<?> saveGenre(@RequestBody SaveGenreReqDTO saveGenreReqDTO) {
        adminService.saveGenre(saveGenreReqDTO);
        return new ResponseEntity<>(MessageRespDTO.builder().message("Жанр сохранен").build(), HttpStatus.OK);
    }

    @PostMapping("/save-country")
    public ResponseEntity<?> saveCountry(@RequestBody SaveCountryReqDTO saveCountryReqDTO) {
        adminService.saveCountry(saveCountryReqDTO);
        return new ResponseEntity<>(MessageRespDTO.builder().message("Страна сохранена"), HttpStatus.OK);
    }

    @PostMapping("/save-movie")
    public ResponseEntity<?> saveMovie(@RequestBody SaveMovieReqDTO saveMovieReqDTO) throws DatabaseException {
        adminService.saveMovie(saveMovieReqDTO);
        return new ResponseEntity<>(MessageRespDTO.builder().message("Фильм сохранен").build(), HttpStatus.OK);
    }
}
