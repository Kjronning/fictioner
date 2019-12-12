package se.hkr.fictioner.model.data_classes;

import org.json.JSONObject;

public class Event extends ParsableData {

    public Event(){
        super("EVENT");
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
