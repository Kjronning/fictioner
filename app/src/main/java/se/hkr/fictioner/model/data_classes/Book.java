package se.hkr.fictioner.model.data_classes;

import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import se.hkr.fictioner.model.data_management.DataRepository;

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
        id = UUID.randomUUID().toString();
    }

    public Book(String userId){
        this();
        this.userId = userId;
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
        if(chapters==null){
            chapters = new RealmList<>();
            DataRepository.AddListToDatabase(chapters);
        }
        return chapters;
    }

    public void setChapters(RealmList<Chapter> chapters) {
        this.chapters = chapters;
    }

    public RealmList<Character> getCharacters() {
        if(characters==null){
            characters = new RealmList<>();
            DataRepository.AddListToDatabase(characters);
        }
        return characters;
    }

    public void setCharacters(RealmList<Character> characters) {
        this.characters = characters;
    }

    public RealmList<Event> getEvents() {
        if(events==null){
            events = new RealmList<>();
            DataRepository.AddListToDatabase(events);
        }
        return events;
    }

    public void setEvents(RealmList<Event> events) {
        this.events = events;
    }

    public RealmList<Location> getLocations() {
        if(locations==null){
            locations = new RealmList<>();
            DataRepository.AddListToDatabase(locations);
        }
        return locations;
    }

    public void setLocations(RealmList<Location> locations) {

        this.locations = locations;
    }

    public RealmList<Note> getNotes() {
        if(notes==null){
            notes = new RealmList<>();
            DataRepository.AddListToDatabase(notes);
        }
        return notes;
    }

    public void setNotes(RealmList<Note> notes) {
        this.notes = notes;
    }
}
