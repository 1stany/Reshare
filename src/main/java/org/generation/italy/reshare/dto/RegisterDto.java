package org.generation.italy.reshare.dto;

import org.generation.italy.reshare.model.AppUser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegisterDto {
    private AppUserDto user;
    private String password;

    public RegisterDto(AppUserDto user, String password) {
        this.user = user;
        this.password = password;
    }

    public AppUser toAppUser(){
        return new AppUser(user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhone(), user.getGender(), LocalDate.parse(user.getBirthdate(), DateTimeFormatter.ofPattern("uuuu-MM-dd")), user.getDescription(), password);
    }

    public AppUserDto getUser(){
        return this.user;
    }

    public String getPassword() {
        return password;
    }
}
