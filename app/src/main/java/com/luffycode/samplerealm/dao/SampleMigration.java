package com.luffycode.samplerealm.dao;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by MacMini on 4/7/17.
 */

public class SampleMigration implements RealmMigration {

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        // DynamicRealm exposes an editable schema
        RealmSchema schema = realm.getSchema();

        if (oldVersion == 1) {
            schema.create("User")
                    .addField("id", int.class, FieldAttribute.PRIMARY_KEY)
                    .addField("name", String.class)
                    .addField("email", String.class)
                    .addField("phone", String.class)
                    .addField("address", String.class)
                    .addField("password", String.class);

            schema.create("Category")
                    .addField("id", int.class, FieldAttribute.PRIMARY_KEY)
                    .addField("name", String.class)
                    .addField("meals", Meal.class);

            schema.create("Meal")
                    .addField("id", int.class, FieldAttribute.PRIMARY_KEY)
                    .addField("name", String.class)
                    .addField("price", int.class)
                    .addField("image", String.class)
                    .addField("note", String.class);

            schema.create("Cart")
                    .addField("id", int.class, FieldAttribute.PRIMARY_KEY)
                    .addField("meal", Meal.class)
                    .addField("user", User.class)
                    .addField("qty", int.class);

            schema.create("Transaction")
                    .addField("id", int.class, FieldAttribute.PRIMARY_KEY)
                    .addField("name", String.class)
                    .addField("address", String.class)
                    .addField("phone", String.class)
                    .addField("note", String.class)
                    .addField("created_at", long.class)
                    .addField("payment", String.class)
                    .addField("status", String.class)
                    .addField("total", int.class)
                    .addField("user", User.class);

            schema.create("TransactionDetail")
                    .addField("id", int.class, FieldAttribute.PRIMARY_KEY)
                    .addField("meal", Meal.class)
                    .addField("qty", int.class);

            oldVersion++;
        }
    }
}
