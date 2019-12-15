package se.hkr.fictioner;

import android.app.Application;

import io.realm.Realm;
import se.hkr.fictioner.model.UserData;
import se.hkr.fictioner.model.data_management.LocalDataSource;

public class MyApplication extends Application {
        @Override
        public void onCreate() {
            super.onCreate();
            Realm.init(this);
            UserData.getInstance().setData(LocalDataSource.getInsance().where(UserData.class).findFirst());
        }
}
