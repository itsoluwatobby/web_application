package com.itsoluwatobby.spring.email.client.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/registration/")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("register")
    public void registerNewUser(@RequestBody RegistrationRequest request) {
    registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
