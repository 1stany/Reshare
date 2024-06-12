package org.generation.italy.reshare.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "object_trade")
public class ItemTrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "request_date")
    private LocalDate requestDate;
    private boolean accepted;
    @Column (name = "exchange_date")
    private LocalDate exchangeDate;
    @OneToOne
    @JoinColumn (name = "requested_object_id")
    private Item requestedItem;         //oggetto che lo user vuole ricevere
    @ManyToOne
    @JoinColumn (name = "requesting_user_id")
    private AppUser requestingUser;
    @OneToOne
    @JoinColumn (name = "exchanged_object_id")
    private Item exchangedItem;         //oggetto dello user che si desidera scambiare
    @ManyToOne
    @JoinColumn (name = "home_user_id")
    private AppUser homeUser;
    @OneToMany (mappedBy = "completedItemTrade")
    private List<Review> reviews = new ArrayList<>();

    public ItemTrade() {}

    public ItemTrade(long id, LocalDate requestDate, boolean accepted, LocalDate exchangeDate) {
        this.id = id;
        this.requestDate = requestDate;
        this.accepted = accepted;
        this.exchangeDate = exchangeDate;
    }

    public Item getRequestedItem() {
        return requestedItem;
    }

    public Item getExchangedItem() {
        return exchangedItem;
    }

    public long getId() {
        return id;
    }

    public LocalDate getRequestedData() {
        return requestDate;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public LocalDate getExchangeDate() {
        return exchangeDate;
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
