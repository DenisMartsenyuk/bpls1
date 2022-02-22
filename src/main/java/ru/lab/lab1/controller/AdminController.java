package ru.lab.lab1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lab.lab1.dto.MessageRespDTO;
import ru.lab.lab1.dto.SaveGenreReqDTO;
import ru.lab.lab1.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/movie-info")
    public ResponseEntity<?> getMovieInfo(@RequestParam(name = "id") Long id) {
        System.out.println(id);
        return null;
    }

    @GetMapping("/human")
    public ResponseEntity<?> getHumans() {

        return null;
    }

    @GetMapping("/genres")
    public ResponseEntity<?> getGeneres() {

        return null;
    }

    @PostMapping("/save-human")
    public ResponseEntity<?> saveHuman() {
        return null;
    }

    @PostMapping("/save-genre")
    public ResponseEntity<?> saveGenre(@RequestBody SaveGenreReqDTO saveGenreReqDTO) {
        adminService.saveGenre(saveGenreReqDTO);
        return new ResponseEntity<>(MessageRespDTO.builder().message("Жанр сохранен").build(), HttpStatus.OK);
    }

    @PostMapping("/save-movie")
    public ResponseEntity<?> saveMovie() {
        return null;
    }
}
