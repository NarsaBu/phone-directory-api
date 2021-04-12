package com.example.phonedirectory.exception;

import com.example.phonedirectory.dto.ErrorMessageDto;
import com.example.phonedirectory.util.GenerateErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessageDto> runtimeExceptionHandler(RuntimeException e) {
        return new ResponseEntity<>(
                GenerateErrorMessage.generateErrorMessage(e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
