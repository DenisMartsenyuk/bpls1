package ru.lab.lab1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageRespDTO {
    private String message;
}
