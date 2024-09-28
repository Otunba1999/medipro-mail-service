package com.otunba.mail.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record MailRequest(@Email(message = "to must  be a valid mail address") String recipient, @NotNull(message = "subject must not be null") @NotEmpty(message = "subject must not be empty") String subject, @NotNull(message = "content must not be null") @NotEmpty(message = "content must not be empty") String content) {
}

