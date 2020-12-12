package ru.goodvard.services.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.goodvard.controller.dto.RegistrationDto;
import ru.goodvard.services.RegistrationService;

import static org.springframework.http.HttpStatus.OK;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public String registrate(RegistrationDto request) {
        return null;
//        return new ResponseEntity<>(result, OK);
    }
}
