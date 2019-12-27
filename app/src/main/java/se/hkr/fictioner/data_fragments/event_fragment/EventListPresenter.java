package se.hkr.fictioner.data_fragments.event_fragment;

import se.hkr.fictioner.data_fragments.RepositoryListContract;
import se.hkr.fictioner.model.data_classes.Event;
import se.hkr.fictioner.model.data_management.DataRepository;

public class EventListPresenter implements RepositoryListContract.Presenter {

    @Override
    public void onBindRepositoryViewAtPosition(int position, RepositoryListContract.ContractView holder) {
        Event event = (Event)DataRepository.GetItemsFromCurrentBook("event").get(position);
        holder.setTitle(event.getName());
        holder.setBody(event.getSummary());
    }
}
