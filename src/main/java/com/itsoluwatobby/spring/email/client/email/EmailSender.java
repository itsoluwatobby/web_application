package com.itsoluwatobby.spring.email.client.email;

public interface EmailSender {

    void sendEmail(String toEmail, String body);
}
