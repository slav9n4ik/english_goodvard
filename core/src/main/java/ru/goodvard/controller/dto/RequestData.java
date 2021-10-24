package ru.goodvard.controller.dto;

import lombok.Data;
import ru.goodvard.repository.entity.UserStatus;

@Data
public class RequestData {
    private String name;
    private String phone;
    private String email;
    private String message;
    private UserStatus status;
}
