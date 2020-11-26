package ru.goodvard.integration.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

import static ru.goodvard.integration.dto.EmailAddressDto.emailOf;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"From", "To", "Subject", "TextPart", "HTMLPart", "CustomID"})
@AllArgsConstructor
public class MessageDto {
    @JsonProperty("From")
    private EmailAddressDto from;
    @JsonProperty("To")
    private List<EmailAddressDto> to;
    @JsonProperty("Subject")
    private String subject;
    @JsonProperty("TextPart")
    private String textPart;
    @JsonProperty("HTMLPart")
    private String hTMLPart;
    @JsonProperty("CustomID")
    private String customID;

    public static MessageDto mainMsgTemplateOf(String from, String name, String to, String subject, String hTMLPart) {
        return new MessageDto(emailOf(name, from), List.of(emailOf(name, to)), subject, "", hTMLPart, "");
    }
}
