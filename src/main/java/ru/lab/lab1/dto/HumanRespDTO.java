package ru.lab.lab1.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class HumanRespDTO implements Serializable {
    private Long id;
    private String name;
    private String surname;
}
