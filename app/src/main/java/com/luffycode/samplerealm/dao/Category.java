package com.luffycode.samplerealm.dao;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by MacMini on 4/7/17.
 */

public class Category extends RealmObject {

    @PrimaryKey
    int id;
    String name;
    RealmList<Meal> meals;

    public Category(){
    }

    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(RealmList<Meal> meals) {
        this.meals = meals;
    }
}
