package se.hkr.fictioner.model.data_classes;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Character extends RealmObject {

    private String name;
    private String summary;
    @PrimaryKey
    private String documentName;
    private Book book;


    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Character(){
    }

    public Character(String name, String summary){
        this.name = name;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
