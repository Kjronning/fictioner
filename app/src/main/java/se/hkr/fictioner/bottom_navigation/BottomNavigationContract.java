package se.hkr.fictioner.bottom_navigation;

import android.view.View;

public interface BottomNavigationContract {

    interface ContractView{
        void switchToCharacterFragment();
        void switchToChapterFragment();
        void switchToEventFragment();
        void switchToLocationFragment();
        void switchToHomeFragment();
        void setFabIcon(int resource);
        }
    interface Presenter {
        void handleCharacterButtonPress();

        void handleChapterButtonPress();

        void handleEventButtonPress();

        void handleLocationButtonPress();

        void handleHomeButtonPress();

        void setButtonIconResource(int iconResource);

        void handleAddButtonPress(View view);

        void setTag(String tag);
    }
}
