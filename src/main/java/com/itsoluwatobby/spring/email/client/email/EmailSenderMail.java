package com.itsoluwatobby.spring.email.client.email;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@AllArgsConstructor
@Slf4j
public class EmailSenderMail implements EmailSender{

    private final JavaMailSender mailSender;

    @Override
    public void sendTo(String to, String email) {

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Please confirm the mail");
            helper.setFrom("akintobby@gmail.com");
            mailSender.send(mimeMessage);
        }
        catch (MessagingException e) {
            log.error("unable to send email");
            throw new IllegalStateException("failed to send email");
        }

    }
}
