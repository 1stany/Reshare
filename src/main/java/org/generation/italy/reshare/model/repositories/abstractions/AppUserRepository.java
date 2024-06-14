package org.generation.italy.reshare.model.repositories.abstractions;

import org.generation.italy.reshare.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByEmail(String email);
}
