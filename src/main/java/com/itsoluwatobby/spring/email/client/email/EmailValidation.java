package com.itsoluwatobby.spring.email.client.email;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailValidation {
    private final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public boolean test(String email) {
        Pattern PATTERN = Pattern.compile(EMAIL_REGEX);
        Matcher match = PATTERN.matcher(email);

        boolean matchFound = match.matches();
        return matchFound;
    }
}
