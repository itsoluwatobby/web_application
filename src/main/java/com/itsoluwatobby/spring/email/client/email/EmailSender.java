package com.itsoluwatobby.spring.email.client.email;

public interface EmailSender {

    void sendTo(String to, String email);
}
