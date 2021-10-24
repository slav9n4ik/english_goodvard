package ru.goodvard.services;

import ru.goodvard.controller.dto.RequestData;

public interface MailRequestProcessor {
    void send(RequestData request);
}
