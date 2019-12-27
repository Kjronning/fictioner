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
                DataRepository.CreateOrEditCharacter((Character)object, nextName, nextBody);
                break;
            case "chapter":
                DataRepository.CreateOrEditChapter((Chapter)object, nextName, nextBody);
                break;
            case "location":
                DataRepository.CreateOrEditLocation((Location)object, nextName, nextBody);
                break;
            case "event":
                DataRepository.CreateOrEditEvent((Event)object, nextName, nextBody);
                break;
            case "note":
                DataRepository.CreateOrEditNote((Note)object, nextName, nextBody);
                break;
        }
    }

    public void deleteObject(RealmObject object) {
        DataRepository.DeleteObject(object);
    }
}
