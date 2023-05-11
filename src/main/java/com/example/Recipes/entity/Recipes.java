package com.example.Recipes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "recipes")
public class Recipes implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "dish_image")
    private String dishImage;

    @Column(name = "description")
    private String description;

    @Column(name = "category_type")
    private int categoryType;

    @Column(name = "cooking_time_minutes")
    private int cookingTimeMinutes;

    @Column(name = "portions")
    private int portions;

    @Column(name = "ingridients")
    @JdbcTypeCode(SqlTypes.JSON)
    private IngridientsData[] ingridients;

    @Column(name = "steps")
    @JdbcTypeCode(SqlTypes.JSON)
    private StepsData[] steps;

    @Column(name = "user_id")
    private int userID;

    @OneToMany
    @JoinColumn(name = "recipe_id")
    private List<Likes> likes;

    @OneToMany
    @JoinColumn(name = "recipe_id")
    private List<Favourites> favourites;

    @OneToMany
    @JoinColumn(name = "recipe_id")
    private List<TagsInRecipe> tagsInRecipe;

}
