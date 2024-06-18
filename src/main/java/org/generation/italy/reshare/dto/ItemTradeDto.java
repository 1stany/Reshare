package org.generation.italy.reshare.dto;

import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.Item;
import org.generation.italy.reshare.model.ItemTrade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ItemTradeDto {
    private long id;
    private String requestDate;
    private boolean accepted;
    private String exchangeDate;
    private String requestedItemName;
    private String requestingUserFullName;
    private String exchangedItemName;
    private String homeUserFullName;
    private long requestedItemId;
    private long requestingUserId;
    private long exchangedItemId;
    private long homeUserId;

    public ItemTradeDto(ItemTrade it) {
        this.id = it.getId();
        this.requestDate = it.getRequestedData().format(DateTimeFormatter.ofPattern("d-MMM-uuuu"));
        this.accepted = it.isAccepted();
        this.exchangeDate = it.getExchangeDate().format(DateTimeFormatter.ofPattern("d-MMM-uuuu"));
        this.requestedItemName = it.getRequestedItem().getName();
        this.requestingUserFullName = it.getRequestingUser().getFullName();
        this.exchangedItemName = it.getExchangedItem().getName();
        this.homeUserFullName = it.getHomeUser().getFullName();
        this.requestedItemId = it.getRequestedItem().getId();
        this.requestingUserId = it.getRequestingUser().getId();
        this.exchangedItemId = it.getExchangedItem().getId();
        this.homeUserId = it.getHomeUser().getId();
    }

    public String getRequestedItemName() {
        return requestedItemName;
    }

    public void setRequestedItemName(String requestedItemName) {
        this.requestedItemName = requestedItemName;
    }

    public String getRequestingUserFullName() {
        return requestingUserFullName;
    }

    public void setRequestingUserFullName(String requestingUserFullName) {
        this.requestingUserFullName = requestingUserFullName;
    }

    public String getExchangedItemName() {
        return exchangedItemName;
    }

    public void setExchangedItemName(String exchangedItemName) {
        this.exchangedItemName = exchangedItemName;
    }

    public String getHomeUserFullName() {
        return homeUserFullName;
    }

    public void setHomeUserFullName(String homeUserFullName) {
        this.homeUserFullName = homeUserFullName;
    }

    public ItemTradeDto() {}

    public long getId() {
        return id;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public long getRequestedItemId() {
        return requestedItemId;
    }

    public void setRequestedItemId(long requestedItemId) {
        this.requestedItemId = requestedItemId;
    }

    public long getRequestingUserId() {
        return requestingUserId;
    }

    public void setRequestingUserId(long requestingUserId) {
        this.requestingUserId = requestingUserId;
    }

    public long getExchangedItemId() {
        return exchangedItemId;
    }

    public void setExchangedItemId(long exchangedItemId) {
        this.exchangedItemId = exchangedItemId;
    }

    public long getHomeUserId() {
        return homeUserId;
    }

    public void setHomeUserId(long homeUserId) {
        this.homeUserId = homeUserId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void setExchangeDate(String exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public String getExchangeDate() {
        return exchangeDate;
    }

    public ItemTrade toItemTrade(Item requestedItem, AppUser requestingUser, Item exchangedItem, AppUser homeUser) {
        return new ItemTrade(LocalDate.parse(this.requestDate, DateTimeFormatter.ofPattern("uuuu-MM-dd") ), this.accepted, LocalDate.parse(this.exchangeDate, DateTimeFormatter.ofPattern("uuuu-MM-dd")), requestedItem, requestingUser, exchangedItem, homeUser);
    }
}
