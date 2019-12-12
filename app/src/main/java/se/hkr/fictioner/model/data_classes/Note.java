package se.hkr.fictioner.model.data_classes;

import org.json.JSONObject;

public class Note extends ParsableData {

    public Note(){
        super("NOTE");
    }

    @Override
    JSONObject parseToJSON() {
        return null;
    }

    @Override
    ParsableData parseFromJSON() {
        return null;
    }
}
