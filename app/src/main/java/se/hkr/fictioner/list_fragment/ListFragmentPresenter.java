package se.hkr.fictioner.list_fragment;

import io.realm.RealmList;
import io.realm.RealmObject;

public class ListFragmentPresenter<T extends RealmObject> implements ListFragmentContract.Presenter {

    private ListFragmentContract.ContractView contractView;

    public ListFragmentPresenter(ListFragmentContract.ContractView contractView){
        this.contractView = contractView;
    }

    @Override
    public void fetchRealmObjectList() {
        //get T.class list from local database for selected book.
        RealmList<T> items = new RealmList<>();
        //set list in view.
        contractView.setListItems(items);
    }
}
