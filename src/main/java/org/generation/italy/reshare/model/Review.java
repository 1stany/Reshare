package org.generation.italy.reshare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private int rating;
    @OneToOne
    @JoinColumn (name = "object_trade_id")
    private ItemTrade completedItemTrade;
    @ManyToOne
    @JoinColumn (name = "app_user_id")
    private AppUser author;
}
