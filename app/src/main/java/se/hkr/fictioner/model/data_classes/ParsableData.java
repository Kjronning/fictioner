package se.hkr.fictioner.model.data_classes;

import org.json.JSONObject;

public abstract class ParsableData {
    private String bookId;
    private String userId;
    private String documentName;
    private long lastUpdated;
    private final String TYPE;

    public ParsableData(String type){
        TYPE = type;
    }

    abstract JSONObject parseToJSON();
    abstract ParsableData parseFromJSON();

}
