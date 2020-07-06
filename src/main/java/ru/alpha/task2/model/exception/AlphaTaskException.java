package ru.alpha.task2.model.exception;

import lombok.Getter;

@Getter
public class AlphaTaskException extends RuntimeException {

    private ExceptionMessage exceptionMessage;

    public AlphaTaskException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }
}
