package se.hkr.fictioner.model.data_classes;

import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;

public abstract class ParsableData extends RealmObject {
    private String documentName;
    private final String TYPE;

    public String getTYPE(){
        return TYPE;
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
        this.documentName = (String)map.get("documentName");
        this.TYPE = (String)map.get("TYPE");
    }

    Map<String, Object> parseToDocumentMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("documentName", documentName);
        map.put("TYPE", TYPE);
        return map;
    }
}
