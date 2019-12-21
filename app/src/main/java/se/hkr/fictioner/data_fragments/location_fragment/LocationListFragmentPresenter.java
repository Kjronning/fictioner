package se.hkr.fictioner.data_fragments.location_fragment;

import io.realm.RealmList;
import se.hkr.fictioner.data_fragments.ListFragmentContract;
import se.hkr.fictioner.model.data_classes.Location;
import se.hkr.fictioner.model.data_management.DataRepository;

public class LocationListFragmentPresenter implements ListFragmentContract.Presenter{

    private ListFragmentContract.ContractView contractView;
    private RealmList<Location> listData;

    public LocationListFragmentPresenter(ListFragmentContract.ContractView contractView) {
        this.contractView = contractView;
        fetchObjectListFromCurrentBook();
    }
    @Override
    public void fetchObjectListFromCurrentBook() {
        listData = DataRepository.GetItemsFromCurrentBook("location");
    }

    @Override
    public void sendListDataToAdapter() {
        contractView.setListItems(listData);
    }
}
