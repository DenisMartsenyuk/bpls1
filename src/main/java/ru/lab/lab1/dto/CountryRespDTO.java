package ru.lab.lab1.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CountryRespDTO implements Serializable {
    private String name;
}
