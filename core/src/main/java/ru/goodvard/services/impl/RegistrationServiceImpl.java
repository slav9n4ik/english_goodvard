package ru.goodvard.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.goodvard.controller.dto.RegistrationDto;
import ru.goodvard.repository.EntityResolver;
import ru.goodvard.services.RegistrationService;

import static ru.goodvard.repository.entity.ParentUser.fromRegistrationDto;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final EntityResolver entityResolver;

    @Override
    public String makeRegistration(RegistrationDto request) {
        entityResolver.saveParentUserIfNotExists(fromRegistrationDto(request));
        //TODO Подтверди емейл
        return null;
    }
}
