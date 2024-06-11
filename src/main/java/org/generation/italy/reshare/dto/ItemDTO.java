package org.generation.italy.reshare.dto;

import jakarta.persistence.Column;
import org.generation.italy.reshare.model.Item;

public class ItemDTO {
    private int id;
    private String name;
    private String description;
    private boolean activetrade;
    private String condition;
    private String conditionComment;

    public ItemDTO() {
    }

    public ItemDTO(Item item){
        this.id = item.getId();
        this.name = item.getName();
        this.condition = item.getCondition();
        this.description = item.getDescription();
        this.conditionComment = item.getConditionComment();
        this.activetrade = item.isActivetrade() ; //Chiedere a Riccardo se tenere boolean o convertirla in stringa

    }

    public Item toItem(){
        return new Item(this.id, this.name, this.condition, this.description, this.conditionComment, this.activetrade);
    }


}
