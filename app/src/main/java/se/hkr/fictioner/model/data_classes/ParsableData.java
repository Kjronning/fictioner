package se.hkr.fictioner.model.data_classes;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

abstract class ParsableData {
    private String bookId;
    private String userId;
    private String documentName;
    private final String TYPE;

    public String getTYPE(){
        return TYPE;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    ParsableData(String type){
        TYPE = type;
    }

    Map<String, Object> parseToDocumentMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("bookId", bookId);
        map.put("userId", userId);
        map.put("documentName", documentName);
        map.put("TYPE", TYPE);
        return map;
    }
    abstract ParsableData parseFromDocumentMap();

}
