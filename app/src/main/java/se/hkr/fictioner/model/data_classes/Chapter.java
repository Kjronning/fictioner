package se.hkr.fictioner.model.data_classes;

import org.json.JSONObject;

import java.util.Map;

public class Chapter extends ParsableData {

    private String name;
    private String body;

    public Chapter(Map<String, Object> map){
        super(map);
        this.name = (String)map.get("name");
        this.body = (String)map.get("body");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Chapter(){
        super("CHAPTER");
    }
    @Override
    Map<String,Object> parseToDocumentMap() {
        Map<String, Object> map = super.parseToDocumentMap();
        map.put("name", name);
        map.put("body", body);
        return map;

    }
}
