package com.example.Recipes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tags")
@Getter
@Setter
public class Tags implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany
    @JoinColumn(name = "tag_id")
    private List<TagsInRecipe> tagsInRecipe;
}
