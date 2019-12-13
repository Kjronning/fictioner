package se.hkr.fictioner.model.data_management;

import android.content.Context;

import io.realm.Realm;

public class LocalDataSource {

    public static void Initialize(Context context){
        Realm.init(context);
    }

    public static Realm getInsance(){
        return Realm.getDefaultInstance();
    }


}
