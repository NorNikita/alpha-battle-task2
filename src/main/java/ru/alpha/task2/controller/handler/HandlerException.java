package ru.alpha.task2.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.alpha.task2.model.dto.StatusDto;
import ru.alpha.task2.model.exception.AlphaTaskException;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(AlphaTaskException.class)
    public ResponseEntity<StatusDto> catchException(AlphaTaskException e) {
        return ResponseEntity
                .status(e.getExceptionMessage().getHttpStatus())
                .body(StatusDto.builder()
                        .status(e.getExceptionMessage().getMessage())
                        .build());
    }
}
