package se.hkr.fictioner.model.data_management;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import se.hkr.fictioner.model.UserData;

public class LocalDataSource {

    public static void Initialize(Context context){
        Realm.init(context);
    }

    public static Realm getInsance(){
        return Realm.getDefaultInstance();
    }


    public static <T extends RealmObject> RealmResults<T> getItemsFromCurrentBook(Class itemClass) {
        return LocalDataSource.getInsance().where(itemClass).equalTo("book.id", UserData.getInstance().getCurrentBookId()).findAll();
    }
}
