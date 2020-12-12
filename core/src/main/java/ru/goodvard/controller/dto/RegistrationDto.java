package ru.goodvard.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.goodvard.entity.ChildUser;
import ru.goodvard.entity.ParentUser;

import java.util.List;

@Data
@AllArgsConstructor
public class RegistrationDto {
    private final ParentUser parentUser;
    private final List<ChildUser> children;
}
