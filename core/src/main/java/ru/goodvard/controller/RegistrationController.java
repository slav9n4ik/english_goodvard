package ru.goodvard.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.goodvard.controller.dto.RegistrationDto;
import ru.goodvard.controller.dto.ResultDto;
import ru.goodvard.services.RegistrationService;

import static org.springframework.http.HttpStatus.OK;
import static ru.goodvard.controller.dto.ResultDto.resultOf;

@Slf4j
@RestController
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PutMapping("/registration")
    public ResponseEntity<ResultDto> registration(@RequestBody RegistrationDto request) {
        log.info("Registration request from: {} {}", request.getParentUserDto().getSurname(), request.getParentUserDto().getEmail());
        return new ResponseEntity<>(resultOf(registrationService.makeRegistration(request)), OK);
    }
}
