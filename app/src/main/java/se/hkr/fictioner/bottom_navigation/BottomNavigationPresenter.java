package se.hkr.fictioner.bottom_navigation;

import android.view.View;

import io.realm.RealmObject;
import se.hkr.fictioner.model.data_classes.Chapter;
import se.hkr.fictioner.model.data_classes.Character;
import se.hkr.fictioner.model.data_classes.Event;
import se.hkr.fictioner.model.data_classes.Location;
import se.hkr.fictioner.model.data_classes.Note;
import se.hkr.fictioner.model.data_management.DataRepository;

public class BottomNavigationPresenter implements BottomNavigationContract.Presenter{

    private BottomNavigationContract.ContractView contractView;
    private String tag;

    public BottomNavigationPresenter(BottomNavigationContract.ContractView contractView){
        this.contractView = contractView;
        tag = "home";
    }

    @Override
    public void handleCharacterButtonPress() {
        contractView.switchToCharacterFragment();
    }

    @Override
    public void handleChapterButtonPress() {
        contractView.switchToChapterFragment();
    }

    @Override
    public void handleEventButtonPress() {
        contractView.switchToEventFragment();
    }

    @Override
    public void handleLocationButtonPress() {
        contractView.switchToLocationFragment();
    }

    @Override
    public void handleHomeButtonPress() {
        contractView.switchToHomeFragment();
    }

    @Override
    public void setButtonIconResource(int iconResource){
        contractView.setFabIcon(iconResource);
    }

    @Override
    public void handleAddButtonPress(View view){
        System.out.println(String.format("add button pressed @ %s fragment", tag));
        switch(tag){
            case "note":
                Note note = DataRepository.AddNoteToCurrentBook(
                        DataRepository.CreateNote(new Note("","")));
                contractView.openEditDialogue(note,tag);
                break;
            case "character":
                Character character = DataRepository.AddCharacterToCurrentBook(
                        DataRepository.CreateCharacter(new Character("","")));
                contractView.openEditDialogue(character,tag);
                break;
            case "chapter":
                Chapter chapter = DataRepository.AddChapterToCurrentBook(
                        DataRepository.CreateChapter(new Chapter("","")));
                contractView.openEditDialogue(chapter,tag);
                break;
            case "event":
                Event event = DataRepository.AddEventToCurrentBook(
                        DataRepository.CreateEvent(new Event("","")));
                contractView.openEditDialogue(event,tag);
                break;
            case "location":
                Location location = DataRepository.AddLocationToCurrentBook(
                        DataRepository.CreateLocation(new Location("","")));
                contractView.openEditDialogue(location,tag);
                break;
        }
    }

    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public void changeBookTitle() {
        contractView.changeBookTitleText(DataRepository.getCurrentBookTitle());
    }

    @Override
    public void handleRecyclerViewClick(String type, int position) {
        RealmObject object = (RealmObject) DataRepository.GetItemsFromCurrentBook(type).get(position);
        contractView.openEditDialogue(object, type);
    }


}
