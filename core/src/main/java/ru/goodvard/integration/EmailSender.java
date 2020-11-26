package ru.goodvard.integration;

public interface EmailSender {
    String sendToAdmin(String to, String subject, String htmlTemplate);
    String sendHtmlText(String name, String to, String subject, String htmlTemplate);
}
