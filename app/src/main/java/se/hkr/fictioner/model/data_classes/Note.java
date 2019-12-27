package se.hkr.fictioner.model.data_classes;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Note extends RealmObject {

    private String body;
    @PrimaryKey
    @Required
    private String documentName = UUID.randomUUID().toString();
    private String name;
    private Book book;

    public Note(){

    }

    public Note(String name, String body){
        this.name = name;
        this.body = body;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString(){
        return "name: " + name + ", id: " + documentName;
    }

}
