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
    private Item requestedItem;         //oggetto che lo user vuole ricevere
    @OneToOne
    @JoinColumn (name = "requesting_user_id")
    private AppUser requestingUser;
    @OneToOne
    @JoinColumn (name = "exchanged_object_id")
    private Item exchangedItem;         //oggetto dello user che si dedisera scambiare
    @OneToOne
    @JoinColumn (name = "home_user_id")
    private AppUser homeUser;
    @OneToOne (mappedBy = "completedItemTrade")
    private Review review;

    public ItemTrade() {}

    public ItemTrade(int id, LocalDate requestDate, boolean accepted, LocalDate excangeDate) {
        this.id = id;
        this.requestDate = requestDate;
        this.accepted = accepted;
        this.excangeDate = excangeDate;
    }

    public Item getRequestedItem() {
        return requestedItem;
    }

    public Item getExchangedItem() {
        return exchangedItem;
    }

    public int getId() {
        return id;
    }

    public LocalDate getRequestedData() {
        return requestDate;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public LocalDate getExcangeDate() {
        return excangeDate;
    }

    public AppUser getRequestingUser() {
        return requestingUser;
    }

    public AppUser getHomeUser() {
        return homeUser;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }
}
