package se.hkr.fictioner.data_fragments.location_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmList;
import se.hkr.fictioner.R;
import se.hkr.fictioner.data_fragments.ListFragmentContract;
import se.hkr.fictioner.databinding.LocationFragmentBinding;

public class LocationListFragment extends Fragment implements ListFragmentContract.ContractView {
    private LocationAdapter adapter;
    private ListFragmentContract.Presenter presenter;
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    public LocationListFragment(){
        adapter = new LocationAdapter(null, true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){

        LocationFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.location_fragment,container,false);
        View view = binding.getRoot();
        binding.setPresenter(presenter);
        recyclerView = view.findViewById(R.id.location_recycler_view);
        recyclerView.setAdapter(adapter);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }
    @Override
    public void setListItems(RealmList items) {
        adapter.updateData(items);
    }

    @Override
    public void openEditDialog() {

    }

    @Override
    public void setPresenter(ListFragmentContract.Presenter presenter) {
        this.presenter = presenter;
    }
}

