package ru.goodvard.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RegistrationDto {
    private final ParentUserDto parentUserDto;
    private final List<ChildUserDto> childrenDto;
}
