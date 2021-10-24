package ru.goodvard.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.goodvard.controller.dto.RequestData;
import ru.goodvard.controller.dto.SendEmailDto;
import ru.goodvard.integration.EmailSender;
import ru.goodvard.integration.HtmlBuilder;
import ru.goodvard.repository.EntityResolver;
import ru.goodvard.services.MailRequestProcessor;

import static ru.goodvard.repository.entity.ParentUser.fromEmailRequestDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailRequestProcessorImpl implements MailRequestProcessor {
    private static final String USER_RESPONSE_SUBJECT = "Сообщение с формы обратной связи GoodVard";

    private final EntityResolver entityResolver;
    private final EmailSender emailSender;
    private final HtmlBuilder htmlBuilder;

    @Value("${main.mail.request.receiver}")
    private String mainReceiver;

    @Override
    public void send(RequestData request) {
        sendToAdmin(request);
        sendToClient(request);
        saveUserData(request);
    }

    private void sendToAdmin(RequestData request) {
        emailSender.sendToAdmin(
                mainReceiver,
                "Сообщение с формы обратной связи от " + request.getName() + "," + request.getEmail(),
                htmlBuilder.adminResponseHtml(request)
        );
    }

    private void sendToClient(RequestData request) {
        emailSender.sendHtmlText(
                request.getName(),
                request.getEmail(),
                USER_RESPONSE_SUBJECT,
                htmlBuilder.customerResponseHtml(request.getName())
        );
    }

    private void saveUserData(RequestData request) {
        entityResolver.saveParentUserIfNotExists(fromEmailRequestDto(request));
    }
}
