package ru.goodvard.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserStatus {
    WANT_TO_GO("Клиенты, которые хотят ходить, но по каким-то причинам с ними еще не было занятий."),
    INTERESTED("Клиенты, которые интересовались, но не пришли."),
    NEW("Записаны, и уже ходили на занятия."),
    OLD("Клиенты, которые уже ходят не один год.");

    private String description;
}
