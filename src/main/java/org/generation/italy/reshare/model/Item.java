package org.generation.italy.reshare.model;

import jakarta.persistence.*;

@Entity
@Table (name = "object")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private boolean activetrade;
    private String condition;
    @Column(name = "condition_comment")
    private String conditionComment;
    @ManyToOne
    @JoinColumn (name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn (name = "owner_id")
    private AppUser owner;
    @OneToOne (mappedBy = "requestedItem")
    private ItemTrade requestedItemTrade;
    @OneToOne (mappedBy = "exchangedItem")
    private ItemTrade exchangedItemTrade;
    @OneToOne (mappedBy = "offeredItem")
    private Offer offer;

}
