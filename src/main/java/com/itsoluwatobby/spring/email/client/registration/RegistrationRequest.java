package com.itsoluwatobby.spring.email.client.registration;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RegistrationRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public RegistrationRequest() {
    }
}
