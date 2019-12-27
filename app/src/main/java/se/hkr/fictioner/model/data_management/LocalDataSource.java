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

    static Chapter AddChapterToCurrentBook(Chapter chapter){
        Realm realm = GetInstance();
        realm.beginTransaction();
        Chapter mChapter = CreateChapter(chapter);
        realm.beginTransaction();
        UserData.getInstance().getUser().getCurrentBook().getChapters().add(mChapter);
        realm.commitTransaction();
        return mChapter;
    }

    static Character AddCharacterToCurrentBook(Character character){
        Realm realm = GetInstance();
        realm.beginTransaction();
        UserData.getInstance().getUser().getCurrentBook().getCharacters().add(character);
        realm.commitTransaction();
        return character;

    }
    static Location AddLocationToCurrentBook(Location location){
        Realm realm = GetInstance();
        Location mLocation = CreateLocation(location);
        realm.beginTransaction();
        UserData.getInstance().getUser().getCurrentBook().getLocations().add(mLocation);
        realm.commitTransaction();
        return mLocation;
    }
    static Event AddEventToCurrentBook(Event event){
       Realm realm = GetInstance();
       realm.beginTransaction();
       Event mEvent = CreateEvent(event);
       realm.commitTransaction();
       realm.beginTransaction();
       UserData.getInstance().getUser().getCurrentBook().getEvents().add(mEvent);
       realm.commitTransaction();
       return mEvent;
    }

    static Note AddNoteToCurrentBook(Note note){
        Realm realm = GetInstance();
        Note mNote = CreateNote(note);
        realm.beginTransaction();
        UserData.getInstance().getUser().getCurrentBook().getNotes().add(mNote);
        realm.commitTransaction();
        return mNote;
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


    static Character CreateCharacter(Character character) {
        Realm realm = GetInstance();
        realm.beginTransaction();
        Character realmObject = realm.copyToRealm(character);
        realm.commitTransaction();
        return realmObject;
    }


    static Chapter CreateChapter(Chapter chapter) {
        Realm realm = GetInstance();
        realm.beginTransaction();
        Chapter realmObject = realm.copyToRealm(chapter);
        realm.commitTransaction();
        return realmObject;
    }

    static Event CreateEvent(Event event) {
        Realm realm = GetInstance();
        realm.beginTransaction();
        Event realmObject = realm.copyToRealm(event);
        realm.commitTransaction();
        return realmObject;
    }

    static Location CreateLocation(Location location) {
        Realm realm = GetInstance();
        realm.beginTransaction();
        Location realmObject = realm.copyToRealm(location);
        realm.commitTransaction();
        return realmObject;
    }

    static Note CreateNote(Note note) {
        Realm realm = GetInstance();
        realm.beginTransaction();
        Note realmObject = realm.copyToRealm(note);
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

    static Character CreateOrEditCharacter(final Character character, final String name, final String summary) {
        GetInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                character.setName(name);
            }
        });
        GetInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                character.setSummary(summary);
            }
        });
        return character;
    }


    static Chapter CreateOrEditChapter(Chapter chapter, String name, String body) {
        GetInstance().beginTransaction();
        chapter.setName(name);
        chapter.setBody(body);
        GetInstance().commitTransaction();
        return GetInstance().copyToRealmOrUpdate(chapter);
    }

    static Event CreateOrEditEvent(Event event, String name, String summary) {
        GetInstance().beginTransaction();
        event.setName(name);
        event.setSummary(summary);
        GetInstance().commitTransaction();
        return GetInstance().copyToRealmOrUpdate(event);
    }

    static Location CreateOrEditLocation(Location location, String name, String summary) {
        GetInstance().beginTransaction();
        location.setName(name);
        location.setSummary(summary);
        GetInstance().commitTransaction();
        return GetInstance().copyToRealmOrUpdate(location);
    }


    static Note CreateOrEditNote(Note note, String name, String body) {
        GetInstance().beginTransaction();
        note.setName(name);
        note.setBody(body);
        GetInstance().commitTransaction();
        return GetInstance().copyToRealmOrUpdate(note);
    }

    static void DeleteObject(final RealmObject object) {
        GetInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                object.deleteFromRealm();
            }
        });
    }
}
