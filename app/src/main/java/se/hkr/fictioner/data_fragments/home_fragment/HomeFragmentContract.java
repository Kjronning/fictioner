package se.hkr.fictioner.data_fragments.home_fragment;

import android.view.View;

import androidx.fragment.app.DialogFragment;

import io.realm.RealmList;
import se.hkr.fictioner.model.data_classes.Book;

public interface HomeFragmentContract {
    interface ContractView{
        void setListItems(RealmList items);
        void setPresenter(HomeFragmentPresenter presenter);
        void openChangeBookDialogue();
        void changeToLoginScreen();
        void openEditBookDialogue();
        void openDialogue(DialogFragment dialogue);
        void setListItemsToSpinner(RealmList<Book> bookListData);
    }
    interface Presenter{
        void sendListDataToAdapter();
        void sendListDataToSpinnerAdapter();
        void fetchObjectListFromCurrentBook();
        void handleLogoutButtonPress(View view);
        void handleChangeBookButtonPress(View view);
        void handleBookTitleEditButtonPress(View view);
        void handleSpinnerAdapterItemSelected(Book book);
    }
}
