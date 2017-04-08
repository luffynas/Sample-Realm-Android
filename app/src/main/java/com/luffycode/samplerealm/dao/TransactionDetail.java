package com.luffycode.samplerealm.dao;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by MacMini on 4/7/17.
 */

public class TransactionDetail extends RealmObject{
    @PrimaryKey
    int id;
    RealmList<Meal> meal;
    int qty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RealmList<Meal> getMeal() {
        return meal;
    }

    public void setMeal(RealmList<Meal> meal) {
        this.meal = meal;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
