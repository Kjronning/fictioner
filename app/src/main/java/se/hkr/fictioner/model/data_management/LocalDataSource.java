package se.hkr.fictioner.model.data_management;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import se.hkr.fictioner.model.UserData;

class LocalDataSource {

    static void Initialize(Context context){
        Realm.init(context);
    }

    static Realm GetInstance(){
        return Realm.getDefaultInstance();
    }

    static <T extends RealmObject> RealmResults<T> GetItemsFromCurrentBook(Class itemClass) {
        return GetInstance().where(itemClass).equalTo("book.id", UserData.getInstance().getCurrentBookId()).findAll();
    }
}
