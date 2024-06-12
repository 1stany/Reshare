package org.generation.italy.reshare.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lockerpoint;
    @OneToMany(mappedBy = "city")
    private List<AppUser> cityUsers = new ArrayList<>();

    public City() {
    }

    public City(String name, String lockerpoint) {
        this.name = name;
        this.lockerpoint = lockerpoint;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLockerpoint() {
        return lockerpoint;
    }
}
