package com.luffycode.samplerealm.dao;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by MacMini on 4/7/17.
 */

public class Cart extends RealmObject {
    @PrimaryKey
    int id;
    Meal meals;
    User user;
    int qty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Meal getMeals() {
        return meals;
    }

    public void setMeals(Meal meals) {
        this.meals = meals;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
