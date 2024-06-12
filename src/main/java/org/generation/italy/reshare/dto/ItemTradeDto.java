package org.generation.italy.reshare.dto;

import org.generation.italy.reshare.model.ItemTrade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ItemTradeDto {
    private long id;
    private String requestDate;
    private boolean accepted;
    private String exchangeDate;

    public ItemTradeDto(ItemTrade it) {
        this.id = it.getId();
        this.requestDate = it.getRequestedData().format(DateTimeFormatter.ofPattern("d-MMM-uuuu"));
        this.accepted = it.isAccepted();
        this.exchangeDate = it.getExchangeDate().format(DateTimeFormatter.ofPattern("d-MMM-uuuu"));
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

    public String getExchangeDate() {
        return exchangeDate;
    }

    public ItemTrade toItemTrade() {
        return new ItemTrade(this.id, LocalDate.parse(this.requestDate, DateTimeFormatter.ofPattern("uuuu-MM-dd") ), this.accepted, LocalDate.parse(this.exchangeDate, DateTimeFormatter.ofPattern("uuuu-MM-dd")));
    }
}
