package com.luffycode.samplerealm.dao;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by MacMini on 4/7/17.
 */

public class Meal extends RealmObject {
    @PrimaryKey
    int id;
    String name;
    int price;
    String image;
    String note;
    int category;

    public Meal(){}

    public Meal(String name, int price, String image, String note, int category){
        this.name = name;
        this.price = price;
        this.image = image;
        this.note = note;
        this.category = category;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

}
