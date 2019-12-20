package se.hkr.fictioner;

import android.app.Application;

import io.realm.RealmConfiguration;
import se.hkr.fictioner.model.data_management.DataRepository;

public class MyApplication extends Application {
        @Override
        public void onCreate() {
            super.onCreate();
            DataRepository.InitializeDataSources(this);
            //RemoveRealmMigration();
        }

    private void RemoveRealmMigration() {
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
    }
}
