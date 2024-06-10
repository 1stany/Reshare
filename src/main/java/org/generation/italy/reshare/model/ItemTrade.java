package org.generation.italy.reshare.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "object_trade")
public class ItemTrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "request_date")
    private LocalDate requestDate;
    private boolean accepted;
    @Column (name = "exchange_date")
    private LocalDate excangeDate;
    @OneToOne
    @JoinColumn (name = "requested_object_id")
    private Item requestedItem;
    @OneToOne
    @JoinColumn (name = "requesting_user_id")
    private AppUser requestingUser;
    @OneToOne
    @JoinColumn (name = "exchanged_object_id")
    private Item exchangedItem;
    @OneToOne
    @JoinColumn (name = "home_user_id")
    private AppUser homeUser;
    @OneToOne (mappedBy = "completedItemTrade")
    private Review review;
}
