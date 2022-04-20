package ru.lab.lab1.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class SendingEmailDTO implements Serializable {
    private List<String> emails;
    private List <MovieRespDTO> movies;
}
