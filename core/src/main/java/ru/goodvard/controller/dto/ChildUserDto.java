package ru.goodvard.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChildUserDto {
    private final String name;
    private final double experience;
    private final double experienceInCurrentSchool;
    private final int ages;
}
