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
    @JoinColumn (name = "offfered_object_id")
    private Item offeredItem;
    @OneToOne
    @JoinColumn (name = "object_type_id")
    private Item offeredItemType;
    @OneToOne
    @JoinColumn (name = "user_id")
    private AppUser offeringUser;
}
