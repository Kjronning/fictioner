package se.hkr.fictioner.model.data_classes;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Event extends RealmObject {
    private String name;
    private String summary;
    @PrimaryKey
    @Required
    private String documentName = UUID.randomUUID().toString();
    private Book book;

    public Event(){
    }

    public Event(String name, String summary){
        this.name = name;
        this.summary = summary;
    }


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
