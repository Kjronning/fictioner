package se.hkr.fictioner.model.data_classes;

import io.realm.RealmList;

public class Book {
    private String id;
    private String userId;
    private RealmList<Chapter> chapters;
    private RealmList<Character> characters;
    private RealmList<Event> events;
    private RealmList<Location> locations;
    private RealmList<Note> notes;

}
