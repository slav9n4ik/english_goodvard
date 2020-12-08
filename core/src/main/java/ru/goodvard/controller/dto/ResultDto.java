package ru.goodvard.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResultDto {
    private final String message;
    private final LocalDateTime time;
}
