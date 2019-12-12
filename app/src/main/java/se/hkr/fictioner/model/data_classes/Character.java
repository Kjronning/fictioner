package se.hkr.fictioner.model.data_classes;

import org.json.JSONObject;

public class Character extends ParsableData {

    public Character(){
        super("CHARACTER");
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
