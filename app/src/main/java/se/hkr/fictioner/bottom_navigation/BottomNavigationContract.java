package se.hkr.fictioner.bottom_navigation;

import android.view.View;

import io.realm.RealmObject;

public interface BottomNavigationContract {

    interface ContractView{
        void switchToCharacterFragment();
        void switchToChapterFragment();
        void switchToEventFragment();
        void switchToLocationFragment();
        void switchToHomeFragment();
        void setFabIcon(int resource);

        void changeBookTitleText(String currentBookTitle);

        void openEditDialogue(RealmObject object, String type);
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

        void changeBookTitle();

        void handleRecyclerViewClick(String type, int position);
    }
}
