package ru.goodvard.reports;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.goodvard.integration.EmailSender;
import ru.goodvard.integration.HtmlBuilder;
import ru.goodvard.repository.EntityResolver;

@Slf4j
@Component
@RequiredArgsConstructor
public class WeeklyReport {
    private final EntityResolver entityResolver;
    private final EmailSender sender;
    private final HtmlBuilder builder;

    @Value("${main.mail.request.receiver}")
    private String adminMail;

    @Scheduled(cron = "${report.cron}")
    public void reportCurrentTime() {
        var count = entityResolver.getUsersCount();
        sender.sendToAdmin(adminMail, "Еженедельный отчет Goodvard", builder.adminWeeklyReportHtml(count));
        log.info("Sending weekly report, {}", count);
    }
}
