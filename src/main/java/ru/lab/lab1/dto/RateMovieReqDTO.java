package ru.lab.lab1.dto;

import lombok.Data;

@Data
public class RateMovieReqDTO {
    private Double value;
    private Long movieId;
    private String login;
}
