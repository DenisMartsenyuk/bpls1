package ru.lab.lab1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lab.lab1.dto.*;
import ru.lab.lab1.exception.DatabaseException;
import ru.lab.lab1.service.AdminService;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

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
        return new ResponseEntity<>(MessageRespDTO.builder().message("Страна сохранена").build(), HttpStatus.OK);
    }

    @PostMapping("/save-movie")
    public ResponseEntity<?> saveMovie(@RequestBody SaveMovieReqDTO saveMovieReqDTO) throws DatabaseException {
        adminService.saveMovie(saveMovieReqDTO);
        return new ResponseEntity<>(MessageRespDTO.builder().message("Фильм сохранен").build(), HttpStatus.OK);
    }
}
