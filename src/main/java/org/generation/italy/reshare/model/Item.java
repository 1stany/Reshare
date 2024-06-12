package org.generation.italy.reshare.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table (name = "object")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private boolean activetrade;
    private String condition;
    @Column(name = "condition_comment")
    private String conditionComment;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private AppUser owner;
//    @OneToOne(mappedBy = "requestedItem")
//    private ItemTrade requestedItemTrade;
//    @OneToOne(mappedBy = "exchangedItem", fetch = FetchType.LAZY)
//    private ItemTrade exchangedItemTrade;
//    @OneToOne(mappedBy = "offeredItem")
//    private Offer offer;
    public static final List<String> CONDITIONS = Arrays.asList("come nuovo", "ottimo", "buono", "accettabile");

    public Item() {
    }

    public Item(long id, String name, String condition, String description, String conditionComment, boolean activetrade) {
        this.id = id;
        this.name = name;
        this.condition = condition;
        this.description = description;
        this.conditionComment = conditionComment;
        this.activetrade = activetrade;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getConditionComment() {
        return conditionComment;
    }

    public String getName() {
        return name;
    }



    public String getCondition() {
        return condition;
    }


    public boolean isActivetrade() {
        return activetrade;
    }

    public void setActivetrade(boolean activetrade) {
        this.activetrade = activetrade;
    }
}
