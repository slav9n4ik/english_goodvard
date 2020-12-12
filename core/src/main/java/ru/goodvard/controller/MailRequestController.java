package ru.goodvard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.goodvard.controller.dto.ResultDto;
import ru.goodvard.controller.dto.SendEmailDto;
import ru.goodvard.services.MailRequestProcessor;

import static org.springframework.http.HttpStatus.OK;
import static ru.goodvard.controller.dto.ResultDto.resultOf;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MailRequestController {

    private final MailRequestProcessor mailRequestProcessor;

    @PostMapping("/api/send")
    public ResponseEntity<ResultDto> sendEmail(@RequestBody SendEmailDto emailDto) {
        log.info("Send email request");
        return new ResponseEntity<>(resultOf(mailRequestProcessor.send(emailDto)), OK);
    }
}
