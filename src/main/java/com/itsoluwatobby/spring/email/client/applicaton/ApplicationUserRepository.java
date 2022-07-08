package com.itsoluwatobby.spring.email.client.applicaton;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
}
