package ru.goodvard.services;

import ru.goodvard.dto.SendEmailDto;

public interface MailRequestProcessor {
    String send(SendEmailDto request);
}
