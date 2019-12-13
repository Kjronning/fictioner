package se.hkr.fictioner.model.data_classes;

import java.util.HashMap;
import java.util.Map;

public abstract class ParsableData {
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

    public ParsableData(String type){
        TYPE = type;
    }

    public ParsableData(Map<String, Object> map) {
        this.bookId = (String)map.get("bookId");
        this.userId = (String)map.get("userId");
        this.documentName = (String)map.get("documentName");
        this.TYPE = (String)map.get("TYPE");
    }

    Map<String, Object> parseToDocumentMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("bookId", bookId);
        map.put("userId", userId);
        map.put("documentName", documentName);
        map.put("TYPE", TYPE);
        return map;
    }
}
