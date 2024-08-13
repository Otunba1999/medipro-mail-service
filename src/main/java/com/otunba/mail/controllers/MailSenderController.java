package com.otunba.mail.controllers;

import com.otunba.mail.dtos.MailRequest;
import com.otunba.mail.services.IEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medipro")
@RequiredArgsConstructor
public class MailSenderController {
    private final IEmailService emailService;

    @PostMapping("/send-simple-message")
    public ResponseEntity<String> sendMail(@RequestBody MailRequest mailRequest) {
         var result = emailService.sendSimpleMail(mailRequest.to(), mailRequest.subject(), mailRequest.content());
         return ResponseEntity.ok(result);
    }
    @PostMapping("/send-html-message")
    public ResponseEntity<String> sendHtmlMail(@RequestBody MailRequest mailRequest)  {
        var result = emailService.sendHtmlMail(mailRequest.to(), mailRequest.subject(), mailRequest.content());
        return ResponseEntity.ok(result);
    }
}
