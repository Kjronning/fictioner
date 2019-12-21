package se.hkr.fictioner.data_fragments.location_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmList;
import se.hkr.fictioner.R;
import se.hkr.fictioner.data_fragments.ListFragmentContract;
import se.hkr.fictioner.data_fragments.MyAdapter;
import se.hkr.fictioner.model.data_classes.Location;

public class LocationListFragment extends Fragment implements ListFragmentContract.ContractView {
    private LocationAdapter adapter;
    private ListFragmentContract.Presenter presenter;
    RecyclerView recyclerView;

    public LocationListFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.location_fragment,
                container, false);
        recyclerView = view.findViewById(R.id.location_recycler_view);
        adapter = new LocationAdapter(null, true);
        recyclerView.setAdapter(adapter);
        return view;
    }
    @Override
    public void setListItems(RealmList items) {
        adapter.updateData(items);
    }

    @Override
    public void setPresenter(ListFragmentContract.Presenter presenter) {
        this.presenter = presenter;
    }
}

