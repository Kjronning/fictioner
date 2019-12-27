package se.hkr.fictioner.model.data_management;

import android.content.Context;

import io.realm.RealmList;
import io.realm.RealmObject;
import se.hkr.fictioner.model.data_classes.Book;
import se.hkr.fictioner.model.data_classes.Chapter;
import se.hkr.fictioner.model.data_classes.Character;
import se.hkr.fictioner.model.data_classes.Event;
import se.hkr.fictioner.model.data_classes.Location;
import se.hkr.fictioner.model.data_classes.Note;
import se.hkr.fictioner.model.user_credentials.PermanentUserData;
import se.hkr.fictioner.model.user_credentials.UserData;
import se.hkr.fictioner.model.data_classes.User;

public class DataRepository {

    public static RealmList GetItemsFromCurrentBook(String type) {
        SyncDataSources();
        return LocalDataSource.GetItemsFromCurrentBook(type);
    }

    public static Book CreateBook(String userId, String name){
        return LocalDataSource.CreateBook(userId, name);
    }

    public static Character CreateCharacter(Character character){
        return LocalDataSource.CreateCharacter(character);
    }

    public static Chapter CreateChapter(Chapter chapter){
        return LocalDataSource.CreateChapter(chapter);
    }

    public static Location CreateLocation(Location location){
        return LocalDataSource.CreateLocation(location);
    }

    public static Event CreateEvent(Event event){
        return LocalDataSource.CreateEvent(event);
    }

    public static Note CreateNote(Note note){
        return LocalDataSource.CreateNote(note);
    }

    public static void BeginTransaction(){
        LocalDataSource.BeginTransaction();
    }

    public static void CommitTransaction(){
        LocalDataSource.CommitTransaction();
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

    public static void AddBookToCurrentUser(Book book) {
        LocalDataSource.AddBookToCurrentUser(book);
    }

    public static void AddListsToDatabase(RealmList ... lists) {
        LocalDataSource.AddListsToDatabase(lists);
    }

    public static void AddListToDatabase(RealmList list){
        LocalDataSource.AddListToDatabase(list);
    }

    public static Note AddNoteToCurrentBook(Note note) {
        return LocalDataSource.AddNoteToCurrentBook(note);
    }

    public static Character AddCharacterToCurrentBook(Character character) {
        return LocalDataSource.AddCharacterToCurrentBook(character);
    }

    public static Chapter AddChapterToCurrentBook(Chapter chapter) {
        return LocalDataSource.AddChapterToCurrentBook(chapter);
    }

    public static Event AddEventToCurrentBook(Event event) {
       return LocalDataSource.AddEventToCurrentBook(event);
    }

    public static Location AddLocationToCurrentBook(Location location) {
        return LocalDataSource.AddLocationToCurrentBook(location);
    }

    public static String getCurrentBookTitle() {
        return UserData.getInstance().getUser().getCurrentBook().getName();
    }

    public static void ChangeCurrentBook(Book book) {
        LocalDataSource.ChangeCurrentBook(book);
    }

    public static void ChangeCurrentBookName(String newTitle) {
        LocalDataSource.ChangeCurrentBookName(newTitle);
    }

    public static Character CreateOrEditCharacter(Character character, String name, String body) {
        return LocalDataSource.CreateOrEditCharacter(character, name, body);
    }

    public static Event CreateOrEditEvent(Event event, String name, String summary) {
        return LocalDataSource.CreateOrEditEvent(event,name,summary);
    }

    public static Location CreateOrEditLocation(Location Location, String name, String summary) {
        return LocalDataSource.CreateOrEditLocation(Location,name,summary);
    }

    public static Note CreateOrEditNote(Note note, String name, String summary) {
        return LocalDataSource.CreateOrEditNote(note,name,summary);
    }

    public static Chapter CreateOrEditChapter(Chapter chapter, String name, String summary) {
        return LocalDataSource.CreateOrEditChapter(chapter,name,summary);
    }

    public static void DeleteObject(RealmObject object) {
        LocalDataSource.DeleteObject(object);
    }
}
