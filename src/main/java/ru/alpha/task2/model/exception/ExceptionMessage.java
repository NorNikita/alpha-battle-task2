package ru.alpha.task2.model.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionMessage {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "user not found");

    private HttpStatus httpStatus;
    private String message;

    ExceptionMessage(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
