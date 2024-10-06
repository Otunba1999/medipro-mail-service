package com.otunba.mail.services.implementations;

import com.otunba.mail.exceptions.MessageException;
import com.otunba.mail.services.IEmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class EmailService implements IEmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);
    @Autowired
    private   JavaMailSender mailSender;
    @Override
    public String  sendSimpleMail(String recipient, String subject, String content) {
        if(recipient == null || recipient.isEmpty() || subject == null || subject.isEmpty() || content == null || content.isEmpty())
            throw new MessageException("Email sending failed, make sure recipient provide a valid email address, subject and content");
        try {
            SimpleMailMessage message = new SimpleMailMessage();
//            message.setFrom(System.getenv("USERNAME"));
            message.setTo(recipient);
            message.setSubject(subject);
            message.setText(content);
            mailSender.send(message);
            return "Email sent successfully";
        } catch (MailException e) {
            log.error("Error sending email", e);
            throw new MessageException("Unable to send email , make sure recipient provide a valid email address, subject and content\n" + e.getMessage());
        }
    }

    @Override
    public String sendHtmlMail(String to, String subject, String content){
        if(to == null || to.isEmpty() || subject == null || subject.isEmpty() || content == null || content.isEmpty())
            throw new MessageException("Email sending failed, make sure to provide a valid email address, subject and content");
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(System.getenv("MAIL_USERNAME"));
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(message);
            return "Email sent successfully";
        } catch (MessagingException | MailException e) {
            log.error("Error sending email", e);
            throw new MessageException("Unable to send mail\n" + e.getMessage());
        }
    }

    @Override
    public String sendAttachmentsMail(String to, String subject, String content, String filePath) {
        if(to == null || to.isEmpty() || subject == null || subject.isEmpty() || content == null || content.isEmpty())
            throw new MessageException("Email sending failed, make sure to provide a valid email address, subject and content");
        return null;
    }
}
