package org.generation.italy.reshare.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String gender;
    private LocalDate birthdate;
    private String description;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @OneToMany (mappedBy = "owner")
    private List<Item> items = new ArrayList<>();
    @OneToOne (mappedBy = "requestingUser")
    private ItemTrade requestingItemTrade;  //oggetto che si vuole riceveree
    @OneToOne (mappedBy = "homeUser")
    private ItemTrade homeItemTrade;        //oggetto dello user che si vuole scambiare
    @OneToMany (mappedBy = "wishingUser")
    private List<ItemType> wishlist = new ArrayList<>();
    @OneToOne (mappedBy = "offeringUser")
    private Offer offer;
    @OneToMany (mappedBy = "author", cascade = {CascadeType.REMOVE})
    private List<ItemType> reviews = new ArrayList<>();

    public AppUser() {
    }

    public ItemTrade getRequestingItemTrade() {
        return requestingItemTrade;
    }

    public ItemTrade getHomeItemTrade() {
        return homeItemTrade;
    }

    public List<Item> getItems() {
        return items;
    }

    public Offer getOffer() {
        return offer;
    }
}
