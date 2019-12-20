package se.hkr.fictioner.model.data_management;

import android.content.Context;

import io.realm.RealmObject;
import io.realm.RealmResults;
import se.hkr.fictioner.model.user_credentials.PermanentUserData;
import se.hkr.fictioner.model.user_credentials.UserData;
import se.hkr.fictioner.model.data_classes.User;

public class DataRepository {

    public static <T extends RealmObject> RealmResults<T> GetItemsFromCurrentBook(Class itemClass) {
        SyncDataSources();
        return LocalDataSource.GetItemsFromCurrentBook(itemClass);
    }

    public static void InitializeDataSources(Context context) {
        LocalDataSource.Initialize(context);
    }

    private static void SyncDataSources(){
        //TODO: Implement method when Remote database is setup.
    }

    public static User GetUserFromDataSource(String username, String password) {
        return LocalDataSource.FindUsernameAndPassword(username, password);
    }

    public static void SetUserForSession(User user) {
        UserData.getInstance().setUser(user);
    }

    public static PermanentUserData GetSavedUserData() {
        return LocalDataSource.GetPermanentUserData();
    }

    public static boolean loggedIn() {
        return LocalDataSource.IsPermanentUserData();
    }

    public static boolean UserAlreadyExists(String username) {
        return LocalDataSource.IsUserInDatabase(username);
    }

    public static void CreateNewUser(User user) {
        LocalDataSource.AddUserToDatabase(user);
    }
}
