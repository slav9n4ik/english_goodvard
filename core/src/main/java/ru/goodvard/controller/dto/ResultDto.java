package ru.goodvard.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Data
public class ResultDto {
    private final String message;
    private final LocalDateTime time;

    public static ResultDto resultOf(String message) {
        return new ResultDto(message, now());
    }
}
