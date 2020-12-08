package ru.goodvard.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.goodvard.controller.dto.ResultDto;
import ru.goodvard.exceptions.SaveDbException;
import ru.goodvard.exceptions.SendMessageException;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(SendMessageException.class)
    protected ResponseEntity<ResultDto> sendMessageException(SendMessageException e) {
        return new ResponseEntity<>(new ResultDto("Send error: " + e.getMessage(), now()), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SaveDbException.class)
    protected ResponseEntity<ResultDto> saveMessageException(SaveDbException e) {
        return new ResponseEntity<>(new ResultDto("Save error: " + e.getMessage(), now()), INTERNAL_SERVER_ERROR);
    }
}
