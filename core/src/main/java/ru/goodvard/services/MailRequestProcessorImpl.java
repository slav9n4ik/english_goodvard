package ru.goodvard.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.goodvard.dto.SendEmailDto;
import ru.goodvard.integration.EmailSender;

@Service
@RequiredArgsConstructor
public class MailRequestProcessorImpl implements MailRequestProcessor {

    private final EmailSender emailSender;
    private final HtmlBuilder htmlBuilder;

    @Value( "${main.mail.request.receiver}" )
    private String mainReceiver;

    @Override
    public String send(SendEmailDto request) {
        String subject = "Сообщение с формы обратной связи от " + request.getName() + "," + request.getEmail();
        emailSender.sendToAdmin(mainReceiver, subject, htmlBuilder.adminResponseHtml(request));
        emailSender.sendHtmlText(request.getName(), request.getEmail(), "Сообщение с формы обратной связи GoodVard",
                htmlBuilder.customerResponseHtml(request.getName()));
        //TODO обработать исключения
        return "Mail send success";
    }
}
