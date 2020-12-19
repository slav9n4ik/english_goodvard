package ru.goodvard.repository.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserStatus {
    REGISTRATION("Зарегистрировались на сайте."),
    SUBSCRIPTION("Подписались на рассылку."),
    INTERESTED("Задали вопрос на сайте."),
    NEW("Записаны, и уже ходили на занятия.");

    private String description;
}
