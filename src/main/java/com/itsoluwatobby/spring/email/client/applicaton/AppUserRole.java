package com.itsoluwatobby.spring.email.client.applicaton;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.itsoluwatobby.spring.email.client.applicaton.AppUserPermission.*;

@AllArgsConstructor
@Getter
public enum AppUserRole {

    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(APPLICATION_WRITE, APPLICATION_READ));

    private Set<AppUserPermission> appUserPermission;

    private Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getAppUserPermission().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermissions()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }

}
