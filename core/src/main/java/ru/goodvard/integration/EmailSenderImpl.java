package ru.goodvard.integration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.goodvard.exceptions.SendMessageException;
import ru.goodvard.integration.dto.MessageList;

import static java.util.List.of;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static ru.goodvard.integration.dto.MessageDto.mainMsgTemplateOf;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSender {

    @Value( "${main.mail.request.sender}" )
    private String from;

    @Value( "${main.mail.request.name}" )
    private String requestName;

    @Value( "${mail.api.key.base64}" )
    private String apiKeyBase64;

    @Value( "${mail.api.url}" )
    private String mailUrl;

    public String sendToAdmin(String to, String subject, String htmlTemplate) {
       return sendHtmlText("Автоматическое письмо администратору", to, subject, htmlTemplate);
    }

    @Override
    public String sendHtmlText(String name, String to, String subject, String htmlTemplate) {
        MessageList messageList = new MessageList(of(mainMsgTemplateOf(from, requestName, to, subject, htmlTemplate)));
        return send(new RestTemplate(), new HttpEntity<>(messageList, makeHeader()));
    }

    private HttpHeaders makeHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.add("Authorization", "Basic " + apiKeyBase64);
        return headers;
    }

    private String send(RestTemplate restTemplate, HttpEntity<MessageList> request) {
        try {
            return restTemplate.postForObject(mailUrl, request, String.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SendMessageException(e.getMessage());
        }
    }
}
