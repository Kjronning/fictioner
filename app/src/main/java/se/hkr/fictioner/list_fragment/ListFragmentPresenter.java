package se.hkr.fictioner.list_fragment;

import se.hkr.fictioner.model.data_management.LocalDataSource;

public class ListFragmentPresenter implements ListFragmentContract.Presenter {

    private ListFragmentContract.ContractView contractView;

    public ListFragmentPresenter(ListFragmentContract.ContractView contractView) {
        this.contractView = contractView;
    }

    @Override
    public void fetchRealmObjectList(Class itemClass) {
        contractView.setListItems(LocalDataSource.getItemsFromCurrentBook(itemClass));
    }
}
