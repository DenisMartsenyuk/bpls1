package ru.lab.lab1.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class MovieRespDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Integer year;
    private Integer runtime;
    private Double averageRating;
    private List<GenreRespDTO> genres;
    private List<CountryRespDTO> countries;
    private List<HumanRespDTO> directors;
    private List<HumanRespDTO> writers;
    private List<HumanRespDTO> actors;
}
