package com.example.Recipes;

import com.example.Recipes.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    static{
        Configuration cfg = new Configuration().configure();
        cfg.addAnnotatedClass(User.class);
        cfg.addAnnotatedClass(Recipes.class);
        cfg.addAnnotatedClass(Likes.class);
        cfg.addAnnotatedClass(Favourites.class);
        cfg.addAnnotatedClass(Categories.class);
        cfg.addAnnotatedClass(Tags.class);
        cfg.addAnnotatedClass(TagsInRecipe.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());
        sessionFactory = cfg.buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }



}
