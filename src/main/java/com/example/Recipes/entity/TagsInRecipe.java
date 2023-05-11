package com.example.Recipes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "tags_in_recipe")
public class TagsInRecipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "recipe_id")
    private int recipeID;

    @Column(name = "tag_id")
    private int tagID;

}
