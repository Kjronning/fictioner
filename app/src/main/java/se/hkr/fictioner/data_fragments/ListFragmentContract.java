package se.hkr.fictioner.data_fragments;

import io.realm.RealmList;

public interface ListFragmentContract {
    interface ContractView{
        void setListItems(RealmList items);
        void openEditDialog();
        void setPresenter(Presenter presenter);
    }
    interface Presenter {
        void fetchObjectListFromCurrentBook();
        void sendListDataToAdapter();
        void handleEditButtonPress();
    }
}
