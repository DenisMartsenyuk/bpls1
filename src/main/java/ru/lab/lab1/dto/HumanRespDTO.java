package ru.lab.lab1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HumanRespDTO {
    private Long id;
    private String name;
    private String surname;
}
