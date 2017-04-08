package com.luffycode.samplerealm.dao;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by MacMini on 4/7/17.
 */

public class UserDAO {
    private static Realm getRealm() {
        Realm realm = Realm.getDefaultInstance();
        return realm;
    }

    public RealmResults<User> getUsers() {
        return getRealm().where(User.class).findAll();
    }

    public User getUser() {
        return getRealm().where(User.class).findFirst();
    }

    public void insert(final String name, final String email, final String phone, final String address, final String password){
        getRealm().executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                User user = realm.createObject(User.class, getNextKey());
                user.setName(name);
                user.setEmail(email);
                user.setPhone(phone);
                user.setAddress(address);
                user.setPassword(password);
            }
        });
    }

    public int getNextKey(){
        try {
            return getRealm().where(User.class).max("id").intValue() + 1;
        } catch (ArrayIndexOutOfBoundsException e){
            return 1;
        } catch (NullPointerException e){
            return 1;
        }
    }
}
