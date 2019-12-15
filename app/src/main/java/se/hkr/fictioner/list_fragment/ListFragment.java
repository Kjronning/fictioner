package se.hkr.fictioner.list_fragment;

import io.realm.RealmObject;
import io.realm.RealmResults;

public class ListFragment <T extends RealmObject> implements ListFragmentContract.ContractView {
    ListFragmentPresenter presenter;

    public ListFragment(ListFragmentPresenter presenter){

    }

}
