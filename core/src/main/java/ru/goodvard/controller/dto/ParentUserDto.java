package ru.goodvard.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParentUserDto {
    private final String name;
    private final String surname;
    private final String middleName;
    private final String email;
    private final String phone;
    private final Boolean subscribe;
}
