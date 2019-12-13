package se.hkr.fictioner.model.data_classes;

import org.json.JSONObject;

import java.util.Map;

public class Note extends ParsableData {

    private String body;

    public Note(Map<String, Object> map){
        super(map);
        this.body = (String)map.get("body");
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Note(){
        super("NOTE");
    }

    @Override
    Map<String,Object> parseToDocumentMap() {
        Map<String, Object> map = super.parseToDocumentMap();
        map.put("body", body);
        return map;
    }
}
