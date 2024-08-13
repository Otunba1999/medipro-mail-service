package com.otunba.mail.exceptions;

import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MailExceptionHandler {

    @ExceptionHandler({MessageException.class, MessagingException.class})
    public ResponseEntity<String> handleMailException(MessageException ex) {
        return ResponseEntity.badRequest().body("An error occurred while processing the request.\n" + ex.getMessage());
    }
}
