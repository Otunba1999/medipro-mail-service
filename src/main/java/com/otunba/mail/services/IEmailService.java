package com.otunba.mail.services;

/**
* This interface handle  the  operation concerning sending of email.
* @author  Otunba
* @version 1.0.0
* @since  2024-07-12
* */
public interface IEmailService {

    /**
     * Sends a simple ,message to a designated email.
     * @param to takes the recipient email address.
     * @param subject the subject of the email
     * @param  content takes the content of the email
     * @return String a success response
     **/
    String sendSimpleMail(String to, String subject, String content) ;
    /**
     * Sends ,message in form of html to a designated email.
     * @param to takes the recipient email address.
     * @param subject the subject of the email
     * @param  content takes html string format
     * @return String a success response
     **/
    String sendHtmlMail(String to, String subject, String content);
    /**
     * Sends a simple ,message to a designated email.
     * @param to takes the recipient email address.
     * @param subject the subject of the email
     * @param  content takes the content of the email
     * @param  filePath takes the file which is to be  attached to the mail.
     * @return String a success response
     **/
    String sendAttachmentsMail(String to, String subject, String content, String filePath);

}
