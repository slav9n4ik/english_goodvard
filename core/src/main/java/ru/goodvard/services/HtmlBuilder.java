package ru.goodvard.services;

import ru.goodvard.dto.SendEmailDto;

public interface HtmlBuilder {
    String customerResponseHtml(String customerName);
    String adminResponseHtml(SendEmailDto request);
}
