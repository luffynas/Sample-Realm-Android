package com.luffycode.samplerealm;

import android.app.Application;

import com.luffycode.samplerealm.dao.SampleMigration;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by MacMini on 4/7/17.
 */

public class SampleApplication extends Application {

    private RealmConfiguration config;

    public static SampleApplication singleton;
    public static SampleApplication getInstance(){
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        Realm.init(this);

        byte[] key = new byte[64];
        //new SecureRandom().nextBytes(key); // Answer https://github.com/realm/realm-java/issues/3545

        // The RealmConfiguration is created using the builder pattern.
        // The Realm file will be located in Context.getFilesDir() with name "myrealm.realm"
        config = new RealmConfiguration.Builder()
                .name("sample.realm")
                .encryptionKey(key)
                .schemaVersion(1)
                /*.modules(new MySchemaModule())*/
                .migration(new SampleMigration())
                .build();

        // Use the config
        //Realm realm = Realm.getInstance(config);
    }

    public RealmConfiguration getConfiguration(){
        return config;
    }
}
