package ru.lab.lab1.dto;

import lombok.Data;

import java.util.List;

@Data
public class SaveMovieReqDTO {
    private Long id;
    private String name;
    private String description;
    private Integer year;
    private Integer runtime;
    private List<String> genres;
    private List<String> countries;
    private List<Long> directors;
    private List<Long> writers;
    private List<Long> actors;
}
