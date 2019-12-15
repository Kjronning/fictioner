package se.hkr.fictioner;

import android.app.Application;

import se.hkr.fictioner.model.data_management.DataRepository;

public class MyApplication extends Application {
        @Override
        public void onCreate() {
            super.onCreate();
            DataRepository.InitializeDataSources(this);
        }
}
