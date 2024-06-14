package org.generation.italy.reshare.controller;

import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.services.abstractions.AppUserService;
import org.generation.italy.reshare.model.services.abstractions.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {
    private AppUserService appUserService;
    private JwtService jwtService;
    AuthenticationManager authenticationManager;

    @Autowired
    public AppUserController(AppUserService appUserService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.appUserService = appUserService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser user) {
        return appUserService.saveUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody AppUser user){

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getEmail());
        else
            return "Login Failed";

    }
}
