package com.otunba.mail.configs;

import org.apache.catalina.connector.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfig {
    private static final Logger log = LoggerFactory.getLogger(MailConfig.class);
    @Value("${server.http.port:8080}")// Default http port
    private int httpPort;

//    @Bean
//    public JavaMailSender getJavaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//        String username = System.getenv("MAIL_USERNAME");
//        String password = System.getenv("PASSWORD");
//        if (username == null || password == null) {
//            throw new IllegalArgumentException("SMTP credentials must be set in environment variables.");
//        }
//        mailSender.setUsername(username);
//        mailSender.setPassword(password);
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true"); // Set to true only during development
//        props.put("mail.smtp.connectiontimeout", "10000"); // 10 seconds
//        props.put("mail.smtp.timeout", "10000"); // 10 seconds
//        props.put("mail.smtp.writetimeout", "10000"); // 10 seconds
//        return mailSender;
//    }
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> httpCustomizer() {
        return factory -> {
            Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
            connector.setScheme("http");
            connector.setPort(httpPort);
            connector.setSecure(false);
            connector.setRedirectPort(8783); // Redirect to HTTPS port
            factory.addAdditionalTomcatConnectors(connector);
        };
    }
}
