package org.generation.italy.reshare.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "object_type")
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @Column (name = "date_added")
    private LocalDate dateAdded;
    @ManyToOne
    @JoinColumn (name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn (name = "wishing_user_id")
    private AppUser wishingUser;
    @OneToOne (mappedBy = "offeredItemType")
    private Offer offer;
}
