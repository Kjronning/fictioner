package se.hkr.fictioner.model.data_classes;

import org.json.JSONObject;

import java.util.Map;

public class Location extends ParsableData {

    private String name;
    private String summary;

    public Location(Map<String, Object> map){
        super(map);
        this.name = (String)map.get("name");
        this.summary = (String)map.get("summary");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Location(){
        super("LOCATION");
    }
    @Override
    Map<String,Object> parseToDocumentMap() {
        Map<String, Object> map = super.parseToDocumentMap();
        map.put("name", name);
        map.put("summary", summary);
        return map;
    }
}
