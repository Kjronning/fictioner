package se.hkr.fictioner.model.data_classes;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import se.hkr.fictioner.model.data_management.DataRepository;

public class User extends RealmObject {
    @PrimaryKey
    private String id;
    private String password;
    private RealmList<Book> books;
    private Book currentBook;

    public User(){    }

    public User(String id, String password){
        this.id = id;
        this.password = password;
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
        if(books==null){
            books = new RealmList<>();
            DataRepository.AddListsToDatabase(books);
        }
        return books;
    }

    public void setBooks(RealmList<Book> books) {
        this.books = books;
    }

    public boolean isPasswordCorrect(String password) {
        if(password!=null)
        return this.password.equals(password);
        return false;
    }

    public Book getCurrentBook(){
        if (currentBook == null){
            Book book = DataRepository.CreateBook(id);
            DataRepository.ChangeCurrentBook(book);
            DataRepository.AddBookToCurrentUser(currentBook);
        }
        return currentBook;
    }

    public void setCurrentBook(Book book) {
        DataRepository.BeginTransaction();
        currentBook = book;
        DataRepository.CommitTransaction();
    }
}
