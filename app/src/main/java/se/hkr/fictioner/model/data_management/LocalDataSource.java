package se.hkr.fictioner.model.data_management;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import se.hkr.fictioner.model.data_classes.Chapter;
import se.hkr.fictioner.model.data_classes.Character;
import se.hkr.fictioner.model.data_classes.Event;
import se.hkr.fictioner.model.data_classes.Location;
import se.hkr.fictioner.model.data_classes.Note;
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

    static RealmList GetItemsFromCurrentBook(String type) {
        switch(type){
            case "character":
                return UserData.getInstance().getUser().getCurrentBook().getCharacters();
            case "event":
                return UserData.getInstance().getUser().getCurrentBook().getEvents();
            case "location":
                return UserData.getInstance().getUser().getCurrentBook().getLocations();
            case "chapter":
                return UserData.getInstance().getUser().getCurrentBook().getChapters();
            case "note":
                return UserData.getInstance().getUser().getCurrentBook().getNotes();
            default:
                return null;
        }
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

    static void SetPermanentUserData(){

    }

    static void AddUserToDatabase(User user) {
        Realm realm = GetInstance();
        realm.beginTransaction();
        realm.copyToRealm(user);
        realm.commitTransaction();
    }

    private static void SaveOrUpdateObjectToRealm(RealmObject object){
        Realm realm = GetInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(object);
        realm.commitTransaction();
    }

    static void UpdatePermanentUserData(PermanentUserData permanentUserData){
        SaveOrUpdateObjectToRealm(permanentUserData);
    }

    static void AddChapterToCurrentBook(Chapter chapter){
        Realm realm = GetInstance();
        realm.beginTransaction();
        UserData.getInstance().getUser().getCurrentBook().getChapters().add(chapter);
        realm.commitTransaction();
    }

    static void AddCharacterToCurrentBook(Character character){
        Realm realm = GetInstance();
        realm.beginTransaction();
        UserData.getInstance().getUser().getCurrentBook().getCharacters().add(character);
        realm.commitTransaction();

    }
    static void AddLocationToCurrentBook(Location location){
        Realm realm = GetInstance();
        realm.beginTransaction();
        UserData.getInstance().getUser().getCurrentBook().getLocations().add(location);
        realm.commitTransaction();
    }
    static void AddEventToCurrentBook(Event event){
       Realm realm = GetInstance();
       realm.beginTransaction();
       UserData.getInstance().getUser().getCurrentBook().getEvents().add(event);
       realm.commitTransaction();
    }

    static void AddNoteToCurrentBook(Note note){
        Realm realm = GetInstance();
        realm.beginTransaction();
        UserData.getInstance().getUser().getCurrentBook().getNotes().add(note);
        realm.commitTransaction();
    }


    static boolean IsUserInDatabase(String username) {
       return GetInstance().where(User.class).contains("id",username).count() == 1;
    }
}
