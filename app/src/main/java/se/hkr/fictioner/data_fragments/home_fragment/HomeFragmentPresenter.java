package se.hkr.fictioner.data_fragments.home_fragment;

import android.view.View;

import io.realm.RealmList;
import se.hkr.fictioner.model.data_classes.Book;
import se.hkr.fictioner.model.data_classes.Note;
import se.hkr.fictioner.model.data_management.DataRepository;
import se.hkr.fictioner.model.user_credentials.UserData;

public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {
    private HomeFragmentContract.ContractView contractView;
    private RealmList<Note> listData;
    private RealmList<Book> bookListData;
    private String newTitle = "new title";

    public HomeFragmentPresenter(HomeFragmentContract.ContractView contractView){
        this.contractView = contractView;
        fetchObjectListFromCurrentBook();
    }

    @Override
    public void sendListDataToAdapter() {
        contractView.setListItems(listData);
    }

    @Override
    public void fetchObjectListFromCurrentBook() {
         listData = DataRepository.GetItemsFromCurrentBook("note");
         bookListData = UserData.getInstance().getUser().getBooks();
    }

    @Override
    public void handleLogoutButtonPress(View view) {
        System.out.println("logout pressed");
        UserData.getInstance().logout();
        contractView.changeToLoginScreen();
    }

    @Override
    public void handleChangeBookButtonPress(View view) {
        contractView.openChangeBookDialogue();
    }

    @Override
    public void handleBookTitleEditButtonPress(View view) {
        System.out.println("Pressed edit button");
        DataRepository.ChangeCurrentBookName(newTitle);
    }

    @Override
    public void handleSpinnerAdapterItemSelected(Book book) {
        DataRepository.ChangeCurrentBook(book);
    }

    @Override
    public void sendListDataToSpinnerAdapter(){
        contractView.setListItemsToSpinner(bookListData);
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }
}
