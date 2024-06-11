package org.generation.italy.reshare.dto;

import org.generation.italy.reshare.model.ItemTrade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ItemTradeDto {
    private int id;
    private String requestDate;
    private boolean accepted;
    private String excangeDate;

    public ItemTradeDto(ItemTrade it) {
        this.id = it.getId();
        this.requestDate = it.getRequestedData().format(DateTimeFormatter.ofPattern("d-MMM-uuuu"));
        this.accepted = it.isAccepted();
        this.excangeDate = it.getExcangeDate().format(DateTimeFormatter.ofPattern("d-MMM-uuuu"));
    }

    public ItemTradeDto() {}

    public int getId() {
        return id;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public String getExcangeDate() {
        return excangeDate;
    }

    public ItemTrade toItemTrade() {
        return new ItemTrade(this.id, LocalDate.parse(this.requestDate, DateTimeFormatter.ofPattern("uuuu-MM-dd") ), this.accepted, LocalDate.parse(this.excangeDate, DateTimeFormatter.ofPattern("uuuu-MM-dd")));
    }
}
