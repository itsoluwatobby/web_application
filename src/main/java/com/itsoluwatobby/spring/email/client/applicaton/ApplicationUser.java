package com.itsoluwatobby.spring.email.client.applicaton;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Entity
@Getter
@Setter
@Table(name = "app_user", uniqueConstraints = @UniqueConstraint(
        columnNames = "email"
))
@NoArgsConstructor
public class ApplicationUser implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "application_user_sequence",
            sequenceName = "application_user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "application_user_sequence"
    )
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email",
            nullable = false,
            unique = true
    )
    private String email;
    @Column(length = 20)
    private String password;
    private boolean locked;
    @Enumerated
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "app_user_role",
            referencedColumnName = "id"
    )
    private AppUserRole appUserRole;
    private boolean enabled = false;

    public ApplicationUser(String firstName,
                           String lastName,
                           String email, String password,
                           boolean locked,
                           AppUserRole appUserRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.locked = locked;
        this.appUserRole = appUserRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
