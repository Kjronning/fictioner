package se.hkr.fictioner.model.data_management;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import se.hkr.fictioner.model.user_credentials.PermanentUserData;
import se.hkr.fictioner.model.user_credentials.UserData;
import se.hkr.fictioner.model.data_classes.User;

class LocalDataSource {

    static void Initialize(Context context){
        Realm.init(context);
    }

    private static Realm GetInstance(){
        return Realm.getDefaultInstance();
    }

    static <T extends RealmObject> RealmResults<T> GetItemsFromCurrentBook(Class itemClass) {
        return GetInstance().where(itemClass).equalTo("book.id", UserData.getInstance().getUser().getCurrentBookId()).findAll();
    }

    static User FindUsernameAndPassword(String username, String password) {
        return GetInstance().where(User.class).equalTo("id", username).contains("password",password).findFirst();
    }

    static boolean IsPermanentUserData() {
        return GetInstance().where(PermanentUserData.class).count() == 1;
    }

    static PermanentUserData GetPermanentUserData(){
        return GetInstance().where(PermanentUserData.class).findFirst();
    }

    static void AddUserToDatabase(User user) {
        GetInstance().createObject(user.getClass(), user);
    }

    static boolean IsUserInDatabase(String username) {
       return GetInstance().where(User.class).contains("id",username).count() == 1;
    }
}
