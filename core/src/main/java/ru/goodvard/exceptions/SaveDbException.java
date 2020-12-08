package ru.goodvard.exceptions;

public class SaveDbException extends RuntimeException {
    public SaveDbException(String message) {
        super(message);
    }
}
