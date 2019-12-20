package se.hkr.fictioner.model.data_classes;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {
    @PrimaryKey
    private String id;
    private String password;
    private RealmList<Book> books;
    private String currentBookId;

    public User(){

    }

    public User(String id, String password){
        this.id = id;
        this.password = password;
        books = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RealmList<Book> getBooks() {
        return books;
    }

    public void setBooks(RealmList<Book> books) {
        this.books = books;
    }

    public String getCurrentBookId() {
        return currentBookId;
    }

    public void setCurrentBookId(String currentBookId) {
        this.currentBookId = currentBookId;
    }
}
