package com.luffycode.samplerealm.dao;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by MacMini on 4/7/17.
 */

public class CartDAO {
    private static Realm getRealm() {
        Realm realm = Realm.getDefaultInstance();
        return realm;
    }

    public int size() {
        return getRealm().where(Cart.class).findAll().size();
    }

    public int getId() {
        return getRealm().where(Cart.class).findFirst().getId();
    }

    public RealmResults<Cart> getCarts() {
        return getRealm().where(Cart.class).findAll();
    }

    public void insert(final int qty, final Meal meal){
        getRealm().executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Cart cart = new Cart();
                User user = new UserDAO().getUser();
                cart.setId(getNextKey());
                cart.setQty(qty);
                cart.setUser(user);
                cart.setMeals(meal);
                realm.copyToRealmOrUpdate(cart);
            }
        });
    }

    public int getNextKey(){
        try {
            return getRealm().where(Cart.class).max("id").intValue() + 1;
        } catch (ArrayIndexOutOfBoundsException e){
            return 1;
        } catch (NullPointerException e){
            return 1;
        }
    }
}
