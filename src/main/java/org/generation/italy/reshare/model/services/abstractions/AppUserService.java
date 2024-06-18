package org.generation.italy.reshare.model.services.abstractions;

import org.generation.italy.reshare.exceptions.EntityNotFoundException;
import org.generation.italy.reshare.model.AppUser;

public interface AppUserService {
    AppUser saveUser(AppUser u);

    AppUser getUserById(long id) throws EntityNotFoundException;
    AppUser getUserByEmail(String email);
}
