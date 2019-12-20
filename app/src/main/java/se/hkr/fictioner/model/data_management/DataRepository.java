package se.hkr.fictioner.model.data_management;

import android.content.Context;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import se.hkr.fictioner.model.user_credentials.PermanentUserData;
import se.hkr.fictioner.model.user_credentials.UserData;
import se.hkr.fictioner.model.data_classes.User;

public class DataRepository {

    public static RealmList GetItemsFromCurrentBook(String type) {
        SyncDataSources();
        return LocalDataSource.GetItemsFromCurrentBook(type);
    }

    public static void InitializeDataSources(Context context) {
        LocalDataSource.Initialize(context);
    }

    private static void SyncDataSources(){
        //TODO: Implement method when Remote database is setup.
    }

    public static User GetUserFromDataSource(String username) {
        return LocalDataSource.GetUserById(username);
    }

    public static void SaveUserData(User user){
        LocalDataSource.UpdatePermanentUserData(new PermanentUserData(user));
    }

    public static void SetUserForSession(User user) {
        UserData.getInstance().setUser(user);
        SaveUserData(user);
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
