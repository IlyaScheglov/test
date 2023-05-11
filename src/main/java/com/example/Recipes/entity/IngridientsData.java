package com.example.Recipes.entity;

import java.io.Serializable;

public class IngridientsData implements Serializable{
    private int countOfIngridients;
    private String nameOfIngridients;
    private String listIngridients;

    public int getCountOfIngridients(){
        return countOfIngridients;
    }

    public void setCountOfIngridients(int countOfIngridients){
        this.countOfIngridients = countOfIngridients;
    }
    public String getNameOfIngridients(){
        return nameOfIngridients;
    }

    public void setNameOfIngridients(String nameOfIngridients){
        this.nameOfIngridients = nameOfIngridients;
    }

    public String getListIngridients(){
        return listIngridients;
    }

    public void setListIngridients(String listIngridients){
        this.listIngridients = listIngridients;
    }

}
