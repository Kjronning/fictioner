package se.hkr.fictioner.model.data_classes;

import org.json.JSONObject;

public abstract class ParsableData {
    Book book;
    String userId;
    String documentName;
    long lastUpdated;
    final String TYPE;

    public ParsableData(String type){
        TYPE = type;
    }

    abstract JSONObject parseToJSON();
    abstract ParsableData parseFromJSON();

}
