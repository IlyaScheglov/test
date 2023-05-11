package com.example.Recipes.entity;

import java.io.Serializable;

public class StepsData implements Serializable{
    private int countStep;
    private String step;

    public int getCountStep(){
        return countStep;
    }
    public void setCountStep(int countStep){
        this.countStep = countStep;
    }

    public String getStep(){
        return step;
    }

    public void setStep(String step){
        this.step = step;
    }
}
