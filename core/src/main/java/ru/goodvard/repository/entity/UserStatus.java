package ru.goodvard.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserStatus {
    REGISTRATION("Зарегистрировались на сайте."),
    SUBSCRIPTION("Подписались на рассылку."),
    INTERESTED("Задали вопрос на сайте. На тему курсов"),
    INTERESTED_VIDEO("Задали вопрос на сайте. На тему видео-курсов"),
    NEW("Записаны, и уже ходили на занятия.");

    private String description;
}
