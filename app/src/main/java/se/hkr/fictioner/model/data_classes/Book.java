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

    public RealmList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(RealmList<Chapter> chapters) {
        this.chapters = chapters;
    }

    public RealmList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(RealmList<Character> characters) {
        this.characters = characters;
    }

    public RealmList<Event> getEvents() {
        return events;
    }

    public void setEvents(RealmList<Event> events) {
        this.events = events;
    }

    public RealmList<Location> getLocations() {
        return locations;
    }

    public void setLocations(RealmList<Location> locations) {
        this.locations = locations;
    }

    public RealmList<Note> getNotes() {
        return notes;
    }

    public void setNotes(RealmList<Note> notes) {
        this.notes = notes;
    }
}
