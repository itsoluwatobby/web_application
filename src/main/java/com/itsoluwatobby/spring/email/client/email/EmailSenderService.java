package com.itsoluwatobby.spring.email.client.email;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
@Slf4j
public class EmailSenderService implements EmailSender{

//    private final Logger LOGGER = LoggerFactory.getLogger(EmailSenderService.class);
    private JavaMailSender mailSender;

    @Override
    @Async
    public void sendEmail(String toEmail, String body) {

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setFrom("akintobby@gmail.com");
            helper.setTo(toEmail);
            helper.setText(body, true);
            helper.setSubject("Please confirm the mail");

            mailSender.send(mimeMessage);
        }
        catch (MessagingException e) {
            log.error("unable to send mail");
            throw new IllegalStateException("failed to send email");
        }
    }
}

