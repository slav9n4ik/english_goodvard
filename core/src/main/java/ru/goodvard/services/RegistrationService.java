package ru.goodvard.services;

import ru.goodvard.controller.dto.RegistrationDto;

public interface RegistrationService {
    String registrate(RegistrationDto request);
}