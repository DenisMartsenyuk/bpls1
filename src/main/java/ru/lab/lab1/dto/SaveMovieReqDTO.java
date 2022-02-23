package ru.lab.lab1.dto;

import lombok.Data;

import java.util.Set;

@Data
public class SaveMovieReqDTO {
    private Long id;
    private String name;
    private String description;
    private Integer year;
    private Integer runtime;
    private Set<String> genres;
    private Set<String> countries;
    private Set<Integer> directors;
    private Set<Integer> writers;
    private Set<Integer> actors;
}
