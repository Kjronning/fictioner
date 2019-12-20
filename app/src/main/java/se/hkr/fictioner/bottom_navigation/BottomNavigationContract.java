package se.hkr.fictioner.bottom_navigation;

public interface BottomNavigationContract {

    interface ContractView{
        void switchToCharacterFragment();
        void switchToChapterFragment();
        void switchToEventFragment();
        void switchToLocationFragment();
        void switchToHomeFragment();
    }
    interface Presenter{
        void handleCharacterButtonPress();
        void handleChapterButtonPress();
        void handleEventButtonPress();
        void handleLocationButtonPress();
        void handleHomeButtonPress();
    }
}
