package ru.goodvard.integration.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Email", "Name"})
@AllArgsConstructor
public class EmailAddressDto {
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Name")
    private String name;

    public static EmailAddressDto emailOf(String name, String email) {
        return new EmailAddressDto(email, name);
    }
}
