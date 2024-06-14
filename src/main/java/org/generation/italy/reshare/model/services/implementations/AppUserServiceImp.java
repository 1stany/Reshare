package org.generation.italy.reshare.model.services.implementations;

import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.repositories.abstractions.AppUserRepository;
import org.generation.italy.reshare.model.services.abstractions.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImp implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public AppUser saveUser(AppUser u) {
        u.setPassword(encoder.encode(u.getPassword()));
        return appUserRepo.save(u);
    }
}
