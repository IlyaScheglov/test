package com.example.Recipes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Likes> likes;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Favourites> favourites;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Recipes> recipes;

}
