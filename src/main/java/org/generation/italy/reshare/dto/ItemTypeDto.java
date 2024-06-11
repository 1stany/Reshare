package org.generation.italy.reshare.dto;

import org.generation.italy.reshare.model.ItemType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ItemTypeDto {

    private int id;
    private String name;
    private String description;
    private String dateAdded;

    public ItemTypeDto(ItemType it) {
        this.id = it.getId();
        this.name = it.getName();
        this.description = it.getDescription();
        this.dateAdded = it.getDateAdded().format(DateTimeFormatter.ofPattern("d-MMM-uuuu"));
    }

    public ItemTypeDto() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDateAdded() {
        return dateAdded;
    }
    public ItemType toItemType() {
        return new ItemType(this.id, this.name, this.description, LocalDate.parse(dateAdded, DateTimeFormatter.ofPattern("uuuu-MM-dd")));
    }
}
