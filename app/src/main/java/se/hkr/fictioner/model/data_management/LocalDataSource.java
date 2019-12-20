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

    static User GetUserById(String username){
        return GetInstance().where(User.class).equalTo("id", username).findFirst();
    }

    static User FindUsernameAndPassword(String username, String password) {
        User managedUser = GetInstance().where(User.class).equalTo("id", username).findFirst();
        if (managedUser == null){
            return null;
        }
        if (managedUser.isPasswordCorrect(password)){
            return managedUser;
        }else{
            return null;
        }
    }

    static boolean IsPermanentUserData() {
        return GetInstance().where(PermanentUserData.class).count() == 1;
    }

    static PermanentUserData GetPermanentUserData(){
        return GetInstance().where(PermanentUserData.class).findFirst();
    }

    static void AddUserToDatabase(User user) {
        Realm realm = GetInstance();
        realm.beginTransaction();
        realm.copyToRealm(user);
        realm.commitTransaction();

    }

    static boolean IsUserInDatabase(String username) {
       return GetInstance().where(User.class).contains("id",username).count() == 1;
    }
}
