package ru.goodvard.integration;

import ru.goodvard.controller.dto.SendEmailDto;

public interface HtmlBuilder {
    String customerResponseHtml(String customerName);
    String adminResponseHtml(SendEmailDto request);
}
