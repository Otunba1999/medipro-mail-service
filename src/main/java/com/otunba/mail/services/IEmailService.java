package com.otunba.mail.services;

import jakarta.mail.MessagingException;

public interface IEmailService {

    String sendSimpleMail(String to, String subject, String content) ;
    String sendHtmlMail(String to, String subject, String content);
    String sendAttachmentsMail(String to, String subject, String content, String filePath);

}
