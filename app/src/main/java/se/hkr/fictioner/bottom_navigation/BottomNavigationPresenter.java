package se.hkr.fictioner.bottom_navigation;

import android.view.View;

import se.hkr.fictioner.model.data_management.DataRepository;
import se.hkr.fictioner.model.user_credentials.UserData;

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
            case "home":
                DataRepository.AddNoteToCurrentBook();
                System.out.println("list: " + UserData.getInstance().getUser().getCurrentBook().getNotes().toString());
                break;
            case "characters":
                DataRepository.AddCharacterToCurrentBook();
                System.out.println("list: " + UserData.getInstance().getUser().getCurrentBook().getCharacters().toString());
                break;
            case "chapters":
                DataRepository.AddChapterToCurrentBook();
                System.out.println("list: " + UserData.getInstance().getUser().getCurrentBook().getChapters().toString());
                break;
            case "events":
                DataRepository.AddEventToCurrentBook();
                System.out.println("list: " + UserData.getInstance().getUser().getCurrentBook().getEvents().toString());
                break;
            case "locations":
                DataRepository.AddLocationToCurrentBook();
                System.out.println("list: " + UserData.getInstance().getUser().getCurrentBook().getLocations().toString());
                break;
        }
    }

    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }

}
