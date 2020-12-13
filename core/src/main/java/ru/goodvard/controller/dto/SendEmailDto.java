package ru.goodvard.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendEmailDto {
    private String name;
    private String phone;
    private String email;
    private String message;
}
