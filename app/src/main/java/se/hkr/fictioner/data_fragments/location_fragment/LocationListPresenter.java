package se.hkr.fictioner.data_fragments.location_fragment;

import android.provider.ContactsContract;

import se.hkr.fictioner.data_fragments.RepositoryListContract;
import se.hkr.fictioner.model.data_classes.Location;
import se.hkr.fictioner.model.data_management.DataRepository;

public class LocationListPresenter implements RepositoryListContract.Presenter {
    @Override
    public void onBindRepositoryViewAtPosition(int position, RepositoryListContract.ContractView holder) {
        Location location = (Location) DataRepository.GetItemsFromCurrentBook("location").get(position);
        holder.setBody(location.getSummary());
        holder.setTitle(location.getName());
    }
}
