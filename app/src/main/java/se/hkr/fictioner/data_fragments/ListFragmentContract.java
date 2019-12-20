package se.hkr.fictioner.data_fragments;

import io.realm.RealmList;

public interface ListFragmentContract {
    interface ContractView{
        void setListItems(RealmList items);

        void setPresenter(Presenter presenter);
    }
    interface Presenter {
        void fetchObjectListFromCurrentBook();
    }
}
