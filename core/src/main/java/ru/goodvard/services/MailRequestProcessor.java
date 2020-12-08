package ru.goodvard.services;

import ru.goodvard.controller.dto.SendEmailDto;

public interface MailRequestProcessor {
    String send(SendEmailDto request);
}
