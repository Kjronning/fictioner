package se.hkr.fictioner.model.data_management;

import android.content.Context;

import io.realm.RealmList;
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

    public static Book CreateBook(String userId){
        return LocalDataSource.CreateBook(userId);
    }

    public static Character CreateCharacter(){
        return LocalDataSource.CreateCharacter();
    }

    public static Chapter CreateChapter(){
        return LocalDataSource.CreateChapter();
    }

    public static Location CreateLocation(){
        return LocalDataSource.CreateLocation();
    }

    public static Event CreateEvent(){
        return LocalDataSource.CreateEvent();
    }

    public static Note CreateNote(){
        return LocalDataSource.CreateNote();
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

    public static void AddNoteToCurrentBook() {
        LocalDataSource.AddNoteToCurrentBook(new Note());
    }

    public static void AddCharacterToCurrentBook() {
        LocalDataSource.AddCharacterToCurrentBook(new Character());
    }

    public static void AddChapterToCurrentBook() {
        LocalDataSource.AddChapterToCurrentBook(new Chapter());
    }

    public static void AddEventToCurrentBook() {
        LocalDataSource.AddEventToCurrentBook(new Event());
    }

    public static void AddLocationToCurrentBook() {
        LocalDataSource.AddLocationToCurrentBook(new Location());
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
}
