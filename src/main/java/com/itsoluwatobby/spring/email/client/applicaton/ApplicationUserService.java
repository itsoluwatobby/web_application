package com.itsoluwatobby.spring.email.client.applicaton;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private ApplicationUserRepository userRepository;
    private final String USER_NOT_FOUND = "User with email % not found";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new IllegalStateException(String.format(USER_NOT_FOUND, email)));
    }

    public String signUp(ApplicationUser applicationUser) {
        boolean userExists = userRepository.findByEmail(applicationUser.getEmail())
                .isPresent();
        if(userExists) {}


        return null;
    }
}
