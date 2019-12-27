package se.hkr.fictioner.model.data_management;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import se.hkr.fictioner.model.data_classes.Book;
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

    static void BeginTransaction() {
        GetInstance().beginTransaction();
    }

    static void SaveItem(RealmObject object) {
        GetInstance().copyToRealm(object);
    }

    static void CommitTransaction(){
        GetInstance().commitTransaction();
    }

    static void AddBookToCurrentUser(Book book) {
        Realm realm = GetInstance();
        realm.beginTransaction();
        UserData.getInstance().getUser().getBooks().add(book);
        realm.commitTransaction();

    }

    static Book CreateBook(String userId, String name) {
        Realm realm = GetInstance();
        realm.beginTransaction();
        Book object = new Book(userId, name);
        Book realmObject = realm.copyToRealm(object);
        realm.commitTransaction();
        return realmObject;
    }


    static Character CreateCharacter() {
        Realm realm = GetInstance();
        realm.beginTransaction();
        Character object = new Character();
        Character realmObject = realm.copyToRealm(object);
        realm.commitTransaction();
        return realmObject;
    }


    static Chapter CreateChapter() {
        Realm realm = GetInstance();
        realm.beginTransaction();
        Chapter object = new Chapter();
        Chapter realmObject = realm.copyToRealm(object);
        realm.commitTransaction();
        return realmObject;
    }

    static Event CreateEvent() {
        Realm realm = GetInstance();
        realm.beginTransaction();
        Event object = new Event();
        Event realmObject = realm.copyToRealm(object);
        realm.commitTransaction();
        return realmObject;
    }

    static Location CreateLocation() {
        Realm realm = GetInstance();
        realm.beginTransaction();
        Location object = new Location();
        Location realmObject = realm.copyToRealm(object);
        realm.commitTransaction();
        return realmObject;
    }

    static Note CreateNote() {
        Realm realm = GetInstance();
        realm.beginTransaction();
        Note object = new Note();
        Note realmObject = realm.copyToRealm(object);
        realm.commitTransaction();
        return realmObject;
    }

    static void AddListsToDatabase(RealmList[] lists) {
        for (RealmList list : lists){
            AddListToDatabase(list);
        }
    }

    static void AddListToDatabase(RealmList list){
        GetInstance().beginTransaction();
        GetInstance().copyToRealm(list);
        GetInstance().commitTransaction();
    }

    static void ChangeCurrentBook(Book book) {
        UserData.getInstance().getUser().setCurrentBook(book);
    }

    static void ChangeCurrentBookName(String newTitle) {
        UserData.getInstance().getUser().getCurrentBook().setName(newTitle);
    }
}
