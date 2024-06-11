package org.generation.italy.reshare.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lockerpoint;
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private List<AppUser> cityUsers = new ArrayList<>();

    public City() {
    }
}
