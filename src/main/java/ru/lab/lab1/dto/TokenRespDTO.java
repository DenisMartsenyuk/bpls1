package ru.lab.lab1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenRespDTO {
    private String token;
}
