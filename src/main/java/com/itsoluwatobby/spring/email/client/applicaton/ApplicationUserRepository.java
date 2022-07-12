package com.itsoluwatobby.spring.email.client.applicaton;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(
            "UPDATE ApplicationUser s SET s.enabled = TRUE Where s.email = ?1"
    )
    void enableAppUser(String email);
}
