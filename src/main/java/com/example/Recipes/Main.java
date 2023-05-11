package com.example.Recipes;

import com.example.Recipes.connectors.UserConnector;
import com.example.Recipes.entity.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.hibernate.Session;
import org.jsoup.Jsoup;

public class Main {
    public static void main(String[] args){
        getSomeDataFromSite();
    }

    public static void getSomeDataFromSite(){
        try {
            var site = Jsoup.connect("https://www.learn-html.org/en/Hello%2C_World%21").get();
            var titleElement = site.selectFirst("title");
            String helloWorld = titleElement.text().substring(0, 13);
            System.out.println(helloWorld);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void registrationNewUser(String login, String password, String name, String email){
        UserConnector userConnector = new UserConnector();
        Argon2 argon2 = Argon2Factory.create();
        char[] charedPassword = password.toCharArray();
        String hashedPassword = argon2.hash(22, 65536, 1, charedPassword);
        userConnector.registration(login, hashedPassword, name, email);
    }

    public static void loginToUser(String login, String password){
        UserConnector userConnector = new UserConnector();
        Argon2 argon2 = Argon2Factory.create();
        char[] charedPassword = password.toCharArray();
        String passwordFromUser = userConnector.logining(login).getPassword();
        if (argon2.verify(passwordFromUser, charedPassword)){
            System.out.println("Вы удачно вошли в пользователя");
        }
        else {
            System.out.println("Логин или пароль был введен неверно");
        }
    }
}
