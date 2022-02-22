package ru.lab.lab1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/movie-info")
    public ResponseEntity<?> getMovieInfo(@RequestParam(name = "id") Long id) {
        System.out.println(id);
        return null;
    }

    @GetMapping("/actors")
    public ResponseEntity<?> getActors() {

        return null;
    }

    @GetMapping("/genres")
    public ResponseEntity<?> getGeneres() {

        return null;
    }

    @PostMapping("/save-actor")
    public ResponseEntity<?> saveActor() {
        return null;
    }

    @PostMapping("/save-genre")
    public ResponseEntity<?> saveGenre() {
        return null;
    }

    @PostMapping("/save-movie")
    public ResponseEntity<?> saveMovie() {
        return null;
    }
}
