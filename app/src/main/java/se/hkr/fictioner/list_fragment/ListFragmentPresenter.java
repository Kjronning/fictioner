package se.hkr.fictioner.list_fragment;

import io.realm.RealmObject;
import io.realm.RealmResults;
import se.hkr.fictioner.model.UserData;
import se.hkr.fictioner.model.data_management.LocalDataSource;

public class ListFragmentPresenter<T extends RealmObject> implements ListFragmentContract.Presenter {

    private ListFragmentContract.ContractView contractView;

    public ListFragmentPresenter(ListFragmentContract.ContractView contractView){
        this.contractView = contractView;
    }

    @Override
    public void fetchRealmObjectList(Class itemClass) {
        //get T.class list from local database for selected book.
        RealmResults<T> items = LocalDataSource.getInsance().where(itemClass).equalTo("book.id", UserData.getInstance().getCurrentBookId()).findAll();
        contractView.setListItems(items);
    }
}
