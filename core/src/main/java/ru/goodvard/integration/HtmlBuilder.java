package ru.goodvard.integration;

import ru.goodvard.controller.dto.RequestData;

public interface HtmlBuilder {
    String customerResponseHtml(String customerName);
    String adminResponseHtml(RequestData request);
    String adminWeeklyReportHtml(long count);
}
