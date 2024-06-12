package org.generation.italy.reshare.dto;

import org.generation.italy.reshare.model.Item;

public class ItemDto {
    private long id;
    private String name;
    private String description;
    private boolean activetrade;
    private String condition;
    private String conditionComment;

    public ItemDto() {
    }

    public ItemDto(Item item){
        this.id = item.getId();
        this.name = item.getName();
        this.condition = item.getCondition();
        this.description = item.getDescription();
        this.conditionComment = item.getConditionComment();
        this.activetrade = item.isActivetrade() ; //Chiedere a Riccardo se tenere boolean o convertirla in stringa

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActivetrade(boolean activetrade) {
        this.activetrade = activetrade;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setConditionComment(String conditionComment) {
        this.conditionComment = conditionComment;
    }

    public Item toItem(){
        return new Item(this.id, this.name, this.condition, this.description, this.conditionComment, this.activetrade);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActivetrade() {
        return activetrade;
    }

    public String getCondition() {
        return condition;
    }

    public String getConditionComment() {
        return conditionComment;
    }
}
