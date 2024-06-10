package org.generation.italy.reshare.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn (name = "category")
    private List<Item> categoryItem = new ArrayList<>();
    @JoinColumn (name = "category")
    private List<ItemType> categoryItemType = new ArrayList<>();
}
