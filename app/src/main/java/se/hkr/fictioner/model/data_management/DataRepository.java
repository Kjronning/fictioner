package se.hkr.fictioner.model.data_management;

import android.content.Context;

import io.realm.RealmObject;
import io.realm.RealmResults;
import se.hkr.fictioner.model.UserData;
import se.hkr.fictioner.model.data_classes.User;

public class DataRepository {

    public static <T extends RealmObject> RealmResults<T> GetItemsFromCurrentBook(Class itemClass) {
        SyncDataSources();
        return LocalDataSource.GetItemsFromCurrentBook(itemClass);
    }

    public static void InitializeDataSources(Context context) {
        LocalDataSource.Initialize(context);
    }

    public static UserData GetUserData() {
        return LocalDataSource.GetInstance().where(UserData.class).findFirst();
    }

    private static void SyncDataSources(){
        //TODO: Implement method when Remote database is setup.
    }

    public static User GetUserFromDataSource(String username, String password) {
        return LocalDataSource.FindUsernameAndPassword(username, password);
    }

    public static void SetUser(User user) {
        UserData.getInstance().setUser(user);
    }
}
