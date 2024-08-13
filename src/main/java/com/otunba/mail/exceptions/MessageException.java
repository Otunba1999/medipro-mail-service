package com.otunba.mail.exceptions;

import org.springframework.mail.MailException;

public class MessageException extends MailException {
    public MessageException(String msg) {
        super(msg);
    }
}
