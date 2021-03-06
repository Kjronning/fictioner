package se.hkr.fictioner.model.data_classes;

import java.util.Map;
import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Chapter extends RealmObject {

    private String name;
    private String body;

    @PrimaryKey
    @Required
    private String documentName = UUID.randomUUID().toString();;
    private Book book;


    public Chapter(String name, String body){
        this.name = name;
        this.body = body;
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
    public Chapter(){
        name = "new chapter";
    }

    public Chapter(Map<String, Object> map){
        //super(map);
        this.name = (String)map.get("name");
        this.body = (String)map.get("body");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /*@Override
    Map<String,Object> parseToDocumentMap() {
        Map<String, Object> map = super.parseToDocumentMap();
        map.put("name", name);
        map.put("body", body);
        return map;

    }*/
}
