package se.hkr.fictioner.model.data_classes;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Book extends RealmObject {
    private String id;
    private String userId;
    private RealmList<Chapter> chapters;
    private RealmList<Character> characters;
    private RealmList<Event> events;
    private RealmList<Location> locations;
    private RealmList<Note> notes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
