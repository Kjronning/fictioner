package se.hkr.fictioner.bottom_navigation;

import io.realm.RealmObject;
import se.hkr.fictioner.model.data_classes.Chapter;
import se.hkr.fictioner.model.data_classes.Character;
import se.hkr.fictioner.model.data_classes.Event;
import se.hkr.fictioner.model.data_classes.Location;
import se.hkr.fictioner.model.data_classes.Note;
import se.hkr.fictioner.model.data_management.DataRepository;

public class EditDialogPresenter {

    public void createObject(RealmObject object, String type, String nextName, String nextBody){
        switch (type){
            case "character":
                Character character = DataRepository.CreateOrEditCharacter((Character)object, nextName, nextBody);
                DataRepository.AddCharacterToCurrentBook(character);
                break;
            case "chapter":
                Chapter chapter = DataRepository.CreateOrEditChapter((Chapter)object, nextName, nextBody);
                DataRepository.AddChapterToCurrentBook(chapter);
                break;
            case "location":
                Location location = DataRepository.CreateOrEditLocation((Location)object, nextName, nextBody);
                DataRepository.AddLocationToCurrentBook(location);
                break;
            case "event":
                Event event = DataRepository.CreateOrEditEvent((Event)object, nextName, nextBody);
                DataRepository.AddEventToCurrentBook(event);
                break;
            case "note":
                Note note = DataRepository.CreateOrEditNote((Note)object, nextName, nextBody);
                DataRepository.AddNoteToCurrentBook(note);
                break;
        }
    }

    public void deleteObject(RealmObject object) {
        DataRepository.DeleteObject(object);
    }
}
