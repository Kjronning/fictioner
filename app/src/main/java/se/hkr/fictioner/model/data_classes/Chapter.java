package se.hkr.fictioner.model.data_classes;

import org.json.JSONObject;

public class Chapter extends ParsableData {

    public Chapter(){
        super("CHAPTER");
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
