package ru.goodvard.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.goodvard.controller.dto.SendEmailDto;
import ru.goodvard.entity.ParentUser;
import ru.goodvard.exceptions.SaveDbException;
import ru.goodvard.integration.EmailSender;
import ru.goodvard.repository.ParentRepository;

import java.util.List;

import static ru.goodvard.entity.ParentUser.fromDto;
import static ru.goodvard.entity.UserStatus.WANT_TO_GO;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailRequestProcessorImpl implements MailRequestProcessor {
    private static final String USER_RESPONSE_SUBJECT = "Сообщение с формы обратной связи GoodVard";

    private final ParentRepository parentRepository;
    private final EmailSender emailSender;
    private final HtmlBuilder htmlBuilder;

    @Value( "${main.mail.request.receiver}" )
    private String mainReceiver;
    @Value( "${main.mail.send}" )
    private Boolean sendIsAvailable;

    @Override
    public String send(SendEmailDto request) {
        if (sendIsAvailable) {
            String subject = "Сообщение с формы обратной связи от " + request.getName() + "," + request.getEmail();
            emailSender.sendToAdmin(mainReceiver, subject, htmlBuilder.adminResponseHtml(request));
            emailSender.sendHtmlText(request.getName(), request.getEmail(), USER_RESPONSE_SUBJECT,
                    htmlBuilder.customerResponseHtml(request.getName()));
        }
        saveUser(request);
        return "Mail send success";
    }

    private void saveUser(SendEmailDto request) {
        List<ParentUser> parentsByPhone = parentRepository.findAllByPhone(request.getPhone());
        if (parentsByPhone.isEmpty()) saveDbUser(fromDto(request, WANT_TO_GO));
    }

    private void saveDbUser(ParentUser user) {
        try {
            parentRepository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SaveDbException(e.getMessage());
        }
    }
}
