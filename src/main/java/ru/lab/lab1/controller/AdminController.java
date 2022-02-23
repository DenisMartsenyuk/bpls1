package ru.lab.lab1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lab.lab1.dto.HumanRespDTO;
import ru.lab.lab1.dto.MessageRespDTO;
import ru.lab.lab1.dto.SaveGenreReqDTO;
import ru.lab.lab1.dto.SaveHumanReqDTO;
import ru.lab.lab1.service.AdminService;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/humans")
    public ResponseEntity<?> getHumans() {
        List<HumanRespDTO> humanRespDTOList = adminService.getHumans().stream()
                .map(x -> HumanRespDTO.builder().id(x.getId()).name(x.getName()).surname(x.getSurname()).build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(humanRespDTOList, HttpStatus.OK);
    }

    @GetMapping("/genres")
    public ResponseEntity<?> getGeneres() {

        return null;
    }

    @PostMapping("/save-human")
    public ResponseEntity<?> saveHuman(@RequestBody SaveHumanReqDTO saveHumanReqDTO) {
        adminService.saveHuman(saveHumanReqDTO);
        return new ResponseEntity<>(MessageRespDTO.builder().message("Актер сохранен").build(), HttpStatus.OK);
    }

    //todo скорее всего не надо, тк это можно делать при сохранении фильма
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
