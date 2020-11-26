package ru.goodvard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.goodvard.dto.ResultDto;
import ru.goodvard.dto.SendEmailDto;
import ru.goodvard.services.MailRequestProcessor;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MailRequestController {

    private final MailRequestProcessor mailRequestProcessor;

    @PostMapping("/api/send")
    public ResponseEntity<ResultDto> sendEmail(@RequestBody SendEmailDto emailDto) {
        log.info("Send email request");
        ResultDto result = new ResultDto(mailRequestProcessor.send(emailDto), now());
        return new ResponseEntity<>(result, OK);
    }
}
