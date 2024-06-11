package org.generation.italy.reshare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private boolean active;
    @OneToOne
    @JoinColumn (name = "offered_object_id")
    private Item offeredItem;
    @OneToOne
    @JoinColumn (name = "object_type_id")
    private ItemType offeredItemType;
    @OneToOne
    @JoinColumn (name = "user_id")
    private AppUser offeringUser;

    public Offer() {
    }

    public Offer(int id, String description, boolean active) {
        this.id = id;
        this.description = description;
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public Item getOfferedItem() {
        return offeredItem;
    }

    public int getId() {
        return id;
    }

    public boolean getActive() {
        return active;
    }
}
