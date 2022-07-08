package com.itsoluwatobby.spring.email.client.webConfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }
}
