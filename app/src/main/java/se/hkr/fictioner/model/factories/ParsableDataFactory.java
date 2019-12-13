package se.hkr.fictioner.model.factories;

import java.util.Map;

import se.hkr.fictioner.model.data_classes.*;
import se.hkr.fictioner.model.data_classes.Character;

public class ParsableDataFactory {
    ParsableData getParsableDataFromMap(Map<String, Object> map) {
        switch ((String) map.get("TYPE")) {
            case "CHARACTER":
                return new Character(map);
            case "LOCATION":
                return new Location(map);
            case "CHAPTER":
                return new Chapter(map);
            case "EVENT":
                return new Event(map);
            case "NOTE":
                return new Note(map);
            default:
                return null;
        }
    }
}
