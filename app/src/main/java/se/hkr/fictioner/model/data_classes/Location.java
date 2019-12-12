package se.hkr.fictioner.model.data_classes;

import org.json.JSONObject;

public class Location extends ParsableData {

    public Location(){
        super("LOCATION");
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
