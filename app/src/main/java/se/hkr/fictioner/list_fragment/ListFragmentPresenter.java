package se.hkr.fictioner.list_fragment;

import se.hkr.fictioner.model.data_management.DataRepository;

public class ListFragmentPresenter<T> implements ListFragmentContract.Presenter {

    private ListFragmentContract.ContractView contractView;

    public ListFragmentPresenter(ListFragmentContract.ContractView contractView) {
        this.contractView = contractView;
    }

    @Override
    public void fetchRealmObjectList(Class itemClass) {
        contractView.setListItems(DataRepository.GetItemsFromCurrentBook(itemClass));
    }
}
