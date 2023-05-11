package com.example.Recipes.connectors;

import com.example.Recipes.HibernateUtil;
import com.example.Recipes.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserConnector {

    private SessionFactory sessionFactory;

    public UserConnector(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<User> getUserListByID(int idOfUser){
        Session session = sessionFactory.openSession();
        List<User> result = null;
        session.beginTransaction();
        String hqlQuery = """
                from User u 
                where u.id = :idOfUser
                """;
        Query query = session.createQuery(hqlQuery);
        query.setParameter("idOfUser", idOfUser);
        result = query.list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List<User> getUserListByLogin(String loginOfUser){
        Session session = sessionFactory.openSession();
        List<User> result = null;
        session.beginTransaction();
        String hqlQuery = """
                from User u 
                where u.login = :loginOfUser
                """;
        Query query = session.createQuery(hqlQuery);
        query.setParameter("loginOfUser", loginOfUser);
        result = query.list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List<User> getUserListByName(String nameOfUser){
        Session session = sessionFactory.openSession();
        List<User> result = null;
        session.beginTransaction();
        String hqlQuery = """
                from User u 
                where u.name = :nameOfUser
                """;
        Query query = session.createQuery(hqlQuery);
        query.setParameter("nameOfUser", nameOfUser);
        result = query.list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List<User> getUserListByEmail(int emailOfUser){
        Session session = sessionFactory.openSession();
        List<User> result = null;
        session.beginTransaction();
        String hqlQuery = """
                from User u 
                where u.email = :emailOfUser
                """;
        Query query = session.createQuery(hqlQuery);
        query.setParameter("emailOfUser", emailOfUser);
        result = query.list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void registration(String login, String password, String name, String email){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    User user = new User();
    user.setLogin(login);
    user.setPassword(password);
    user.setName(name);
    user.setEmail(email);
    session.save(user);
    session.getTransaction().commit();
    session.close();
    }

    public User logining(String login){
        User result = null;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hqlQuery = """
                from User u where 
                u.login = :log
                """;
        Query query = session.createQuery(hqlQuery);
        query.setParameter("log", login);
        query.setMaxResults(1);
        List<User> userList = query.list();
        session.getTransaction().commit();
        session.close();
        for (var element : userList){
            result = element;
        }
        return result;
    }

}
