package org.generation.italy.reshare.dto;

import org.generation.italy.reshare.model.Category;

public class CategoryDto {
    private int id;
    private String name;
    private String description;

    public CategoryDto() {}

    public CategoryDto(Category cat) {
        this.id = cat.getId();
        this.name = cat.getName();
        this.description = cat.getDescription();
    }

    public Category toCategory(){
        return new Category(this.id, this.name, this.description);
    }
}
