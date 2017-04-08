package com.luffycode.samplerealm.dao;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by MacMini on 4/7/17.
 */

public class CategoryDAO {
    private static Realm getRealm() {
        Realm realm = Realm.getDefaultInstance();
        return realm;
    }

    public RealmResults<Category> getCategories() {
        return getRealm().where(Category.class).findAll();
    }

    public RealmResults<Category> getCategories(int id) {
        return getRealm().where(Category.class).equalTo("id", id).findAll();
    }

    public void insert(final List<String> categories){
        getRealm().executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (int i = 0; i < categories.size(); i++) {
                    Category category = realm.createObject(Category.class, getNextKey());
                    category.setName(categories.get(i));
                }
            }
        });
    }

    public int getNextKey(){
        try {
            return getRealm().where(Category.class).max("id").intValue() + 1;
        } catch (ArrayIndexOutOfBoundsException e){
            return 1;
        } catch (NullPointerException e){
            return 1;
        }
    }
}
