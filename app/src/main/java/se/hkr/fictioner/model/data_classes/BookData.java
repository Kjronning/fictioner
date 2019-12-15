package se.hkr.fictioner.model.data_classes;

import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public abstract class BookData extends RealmObject {
    @PrimaryKey
    private String documentName;
    private Book book;


    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public BookData(){}

    public BookData(Map<String, Object> map) {
        this.documentName = (String)map.get("documentName");
    }

    Map<String, Object> parseToDocumentMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("documentName", documentName);
        return map;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
