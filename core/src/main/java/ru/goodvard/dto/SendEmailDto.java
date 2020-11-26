package ru.goodvard.dto;

import lombok.Data;

@Data
public class SendEmailDto {
    private String name;
    private String phone;
    private String email;
    private String message;
}
