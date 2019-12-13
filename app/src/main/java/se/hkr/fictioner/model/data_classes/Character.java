package se.hkr.fictioner.model.data_classes;

import org.json.JSONObject;

import java.util.Map;

public class Character extends ParsableData {

    public Character(Map<String, Object> map){
        super(map);
        this.name = (String)map.get("name");
        this.summary = (String)map.get("summary");
    }

    private String name;
    private String summary;

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

    public Character(){
        super("CHARACTER");
    }

    @Override
    Map<String,Object> parseToDocumentMap() {
       Map<String, Object> map = super.parseToDocumentMap();
       map.put("name", name);
       map.put("summary", summary);
       return map;
    }
}
