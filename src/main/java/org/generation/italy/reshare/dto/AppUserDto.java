package org.generation.italy.reshare.dto;

import org.generation.italy.reshare.model.AppUser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AppUserDto {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String gender;
    private String birthdate;
    private String description;

    public AppUserDto() {}

    public AppUserDto(AppUser appUser) {
        this.id = appUser.getId();
        this.firstname = appUser.getFirstname();
        this.lastname = appUser.getLastname();
        this.email = appUser.getEmail();
        this.phone = appUser.getPhone();
        this.gender = appUser.getGender();
        this.birthdate = appUser.getBirthdate().format(DateTimeFormatter.ofPattern("d-MMM-uuuu"));
        this.description = appUser.getDescription();
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getDescription() {
        return description;
    }

    public AppUser toAppUser(){
        return new AppUser(this.firstname, this.lastname, this.email, this.phone, this.gender, LocalDate.parse(this.birthdate, DateTimeFormatter.ofPattern("uuuu-MM-dd")), this.description);
    }
}
