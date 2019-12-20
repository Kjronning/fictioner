package se.hkr.fictioner.model.data_classes;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Book extends RealmObject {
    @PrimaryKey
    private String id;
    private String userId;
    private RealmList<Chapter> chapters;
    private RealmList<Character> characters;
    private RealmList<Event> events;
    private RealmList<Location> locations;
    private RealmList<Note> notes;

    public Book(){
        chapters = new RealmList<>();
        characters = new RealmList<>();
        events = new RealmList<>();
        locations = new RealmList<>();
        notes = new RealmList<>();
    }

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
