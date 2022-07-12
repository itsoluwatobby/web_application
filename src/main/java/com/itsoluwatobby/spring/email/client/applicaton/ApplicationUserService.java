package com.itsoluwatobby.spring.email.client.applicaton;

import com.itsoluwatobby.spring.email.client.registration.token.ConfirmationToken;
import com.itsoluwatobby.spring.email.client.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final String USER_NOT_FOUND = "User with email % not found";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return applicationUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new IllegalStateException(String.format(USER_NOT_FOUND, email)));
    }

    public String signUp(ApplicationUser applicationUser) {
        boolean userExists = applicationUserRepository.findByEmail(applicationUser.getEmail())
                .isPresent();
        if(userExists) {
            //still need to write the logic for missing token confirmation

            throw new IllegalStateException(String.format("Email % already taken", applicationUser.getEmail()));
        }
        String encodedPassword = passwordEncoder.encode(applicationUser.getPassword());

                applicationUser.setPassword(encodedPassword);
        applicationUserRepository.save(applicationUser);

        //Generate, Save and Send token
        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                        token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                        applicationUser
        );
        confirmationTokenService.saveToken(confirmationToken);

        //send email

        return token;
    }

    public void enableAppUser(String email) {
        applicationUserRepository.enableAppUser(email);
    }
}
