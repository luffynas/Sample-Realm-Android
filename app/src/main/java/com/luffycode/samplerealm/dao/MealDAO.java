package com.luffycode.samplerealm.dao;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by MacMini on 4/7/17.
 */

public class MealDAO {
    private static Realm getRealm() {
        Realm realm = Realm.getDefaultInstance();
        return realm;
    }

    public RealmResults<Meal> getMeals() {
        return getRealm().where(Meal.class).findAll();
    }

    public Meal getSingleMeal(int id) {
        return getRealm().where(Meal.class).equalTo("id", id).findFirst();
    }

    public RealmList<Meal> getMeal(int idCategory) {
        Category categories = getRealm().where(Category.class)
                .equalTo("id", idCategory)
                .findFirst();
        return categories.getMeals();
    }

    public void insert(final List<Meal> meals){
        getRealm().executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (int i = 0; i < meals.size(); i++) {
                    Category category = new CategoryDAO().getCategories(meals.get(i).getCategory()).first();
                    Meal meal = new Meal();
                    meal.setId(getNextKey());
                    meal.setName(meals.get(i).getName());
                    meal.setPrice(meals.get(i).getPrice());
                    meal.setImage(meals.get(i).getImage());
                    meal.setNote(meals.get(i).getNote());
                    realm.copyToRealmOrUpdate(meal);
                    category.getMeals().add(meal);
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("Success", "Success ");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e("Error", error.getMessage());
            }
        });
    }

    public int getNextKey(){
        try {
            return getRealm().where(Meal.class).max("id").intValue() + 1;
        } catch (ArrayIndexOutOfBoundsException e){
            return 1;
        } catch (NullPointerException e){
            return 1;
        }
    }
}
