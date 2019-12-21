package se.hkr.fictioner.data_fragments.event_fragment;

import io.realm.RealmList;
import se.hkr.fictioner.data_fragments.ListFragmentContract;
import se.hkr.fictioner.model.data_classes.Event;
import se.hkr.fictioner.model.data_management.DataRepository;

public class EventListFragmentPresenter  implements ListFragmentContract.Presenter{

    private ListFragmentContract.ContractView contractView;
    private RealmList<Event> listData;

    public EventListFragmentPresenter(ListFragmentContract.ContractView contractView) {
        this.contractView = contractView;
        fetchObjectListFromCurrentBook();
    }
    @Override
    public void fetchObjectListFromCurrentBook() {
        listData = DataRepository.GetItemsFromCurrentBook("event");

    }

    @Override
    public void sendListDataToAdapter() {

        contractView.setListItems(listData);
    }
}
