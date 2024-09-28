package com.otunba.mail.controllers;

import com.otunba.mail.dtos.MailRequest;
import com.otunba.mail.services.IEmailService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medipro")
@RequiredArgsConstructor
@Tag(name = "Email Service management", description = "A service use for sending email to  a designated address.")
public class MailSenderController {
    private final IEmailService emailService;

    @PostMapping("/send-simple-message")
    @Operation(summary = "Send a simple message to a email address")
    public ResponseEntity<String> sendMail(@Valid @RequestBody MailRequest mailRequest) {
         var result = emailService.sendSimpleMail(mailRequest.recipient(), mailRequest.subject(), mailRequest.content());
         return ResponseEntity.ok(result);
    }
    @PostMapping("/send-html-message")
    @Operation(summary = "Send a HTML content to a email address")
    public ResponseEntity<String> sendHtmlMail(@Valid @RequestBody MailRequest mailRequest)  {
        var result = emailService.sendHtmlMail(mailRequest.recipient(), mailRequest.subject(), mailRequest.content());
        return ResponseEntity.ok(result);
    }
}
